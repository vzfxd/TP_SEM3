package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;

public class WordCensor extends SocialChannelDecorator{

    public WordCensor(){}
    public WordCensor(SocialChannel decoratedChannel){
        this.delegate = decoratedChannel;
    }
    @Override
    public void deliverMessage(String message) {
        while (message.contains("message")){
            StringBuilder builder = new StringBuilder(message);
            builder.insert(builder.indexOf("message"),"#");
            int i = builder.indexOf("message");
            for (int j=0;j<7;j++){
                builder.deleteCharAt(i);
                message = builder.toString();
            }
        }
        delegate.deliverMessage(message);
    }
}
