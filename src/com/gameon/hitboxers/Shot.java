package com.gameon.hitboxers;
 
import java.awt.Graphics2D;
import java.awt.Image;
 
public class Shot extends Hitboxer {
        private int type;
 
       
        public Shot(Image image, Image[] da, Player p, int t) {
                super(image, da);
                this.x = p.x + 37;
                this.setLane(p.getLane());
                this.y = p.y - 80;
                this.width = 27;
                this.height = 69;
                this.setType(t);
        }
        public void move(){
                //y-=20;
                int grad = 0;
                if(getLane() == 3)
                        grad = 250;
                if(getLane() == 1)
                        grad = 270;
                if (getLane()== -1)
                        grad = 290;
                       
                x += 15 * Math.cos(Math.toRadians(grad));
                y += 15 * Math.sin(Math.toRadians(grad));
               
               
               
       
        }
        public void draw(Graphics2D g) {
                if (isKilled()) {
                        if(!(getDeathAnimation().length < getDeathState())){
                                g.drawImage(getDeathAnimation()[getDeathState()], x +(95*getLane()), y, width, height, null);
                                setDeathState(getDeathState() + 1);
                        }
                } else {
                        int lane = getLane();
                        if(lane == 3)
                                lane=2;
                        if(lane == 1)
                                lane = 0;
                        if(lane == -1)
                                lane = -2;
                        g.drawImage(getImage(),x +(95*lane), y, width, height, null);
                        // (540 + (100 * getLane()))
                       
                }
 
        }
		public int getType() {
			return type;
		}
		public void setType(int type){
			this.type = type;
		}
}