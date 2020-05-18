package sever.handler.chat;

import base.KSocket;
import base.Message;
import base.json.MessageJson;
import sever.base.ClientHandler;
import sever.base.KSever;

import java.io.IOException;

public class ChatClientHandler extends ClientHandler {
    private String userid = "-1000";

    public String getUserid(){
        return userid;
    }

    public ChatClientHandler(KSever sever, KSocket socket, ChatMessageHandler handler ) {
        super (sever, socket);
        this.messageHandler = handler;
        ((ChatMessageHandler) this.messageHandler).setClientHandler (this);
    }

    @Override
    public void update() {
        new Thread(()->{
            try {
                while (true){
                    var message = Message.prase (client.readUTF ());
                    messageHandler.handleMessage (message);
                }
            } catch (IOException e) {
                e.printStackTrace ( );
            }
        }).start ();
    }


    public void sendMessageToSever(MessageJson json){

    }

    public void sendNewMessage(MessageJson message){
        try {
            client.writeUTF (new Message (0,0,message.toString ()).toString ());
        } catch (IOException e) {
            e.printStackTrace ( );
        }
    }

    public void setUserid(String props) {
        userid = props;

    }
}
