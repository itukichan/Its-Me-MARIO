
package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Rule extends Mario {
    Graphics gra = frame.panel.image.createGraphics();
    public void RulePaint() {
        if( Keyboard.isKeyPressed(KeyEvent.VK_ESCAPE)) {
            screen = EnumScreen.START;
        }
    }
    public void  Rule1() {
            gra.setFont(gra.getFont().deriveFont(Font.BOLD,60F));
            String how = "↑→←で移動、ジャンプ";

            //SHADOW
            gra.setColor(Color.black);
            gra.drawString(how, 120+3,300+3);

            //MAIN COLOR
            gra.setColor(Color.white);
            gra.drawString(how,120,300);

            gra.setFont(gra.getFont().deriveFont(Font.BOLD,30F));
            String how1 = "ESCでタイトル画面へ";

            //SHADOW
            gra.setColor(Color.black);
            gra.drawString(how1, 300+3,450+3 );

            //MAINCOLOR
            gra.setColor(Color.white);
            gra.drawString(how1,300,450);
        }
    }