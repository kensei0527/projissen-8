import java.awt.*;
import java.awt.event.*;

public class DrawingApli00 extends Frame implements ActionListener {
  // ■ フィールド変数
  Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8; // フレームに配置するボタンの宣言
  Button btc1,btc2,btc3,btc4,btc5,btc6;
  Panel  pnl,clpnl;                // ボタン配置用パネルの宣言
  MyCanvas2 mc;               // 別途作成した MyCanvas クラス型の変数の宣言

  // ■ main メソッド（スタート地点）
  public static void main(String [] args) {
    DrawingApli00 da = new DrawingApli00(); 
  }

  // ■ コンストラクタ
  DrawingApli00() {
    super("Drawing Appli");
    this.setSize(600, 400); 

    pnl = new Panel();       // Panel のオブジェクト（実体）を作成
    mc = new MyCanvas2(this); // mc のオブジェクト（実体）を作成
    clpnl = new Panel();

    this.setLayout(new BorderLayout(10, 10)); // レイアウト方法の指定
    this.add(pnl, BorderLayout.EAST);         // 右側に パネルを配置
    this.add(mc,  BorderLayout.CENTER);       // 左側に mc （キャンバス）を配置
    this.add(clpnl, BorderLayout.WEST);
                                         // BorerLayout の場合，West と East の幅は
                                         // 部品の大きさで決まる，Center は West と East の残り幅
    pnl.setLayout(new GridLayout(9,1));  // ボタンを配置するため，９行１列のグリッドをパネル上にさらに作成
    bt1 = new Button("Free Hand"); bt1.addActionListener(this); pnl.add(bt1);// ボタンを順に配置
    bt2 = new Button("Line");      bt2.addActionListener(this); pnl.add(bt2);
    bt3 = new Button("Rectangle"); bt3.addActionListener(this); pnl.add(bt3);
    bt4 = new Button("Oval");      bt4.addActionListener(this); pnl.add(bt4);
    bt5 = new Button("FillOval");   bt5.addActionListener(this); pnl.add(bt5);
    bt6 = new Button("FillRect");   bt6.addActionListener(this); pnl.add(bt6);
    bt7 = new Button("All Delate"); bt7.addActionListener(this); pnl.add(bt7);
    bt8 = new Button("Eraser"); bt8.addActionListener(this);    pnl.add(bt8);

    clpnl.setLayout(new GridLayout(6,1));
    btc1 = new Button("black"); btc1.addActionListener(this); clpnl.add(btc1);
    btc2 = new Button("red"); btc2.addActionListener(this); clpnl.add(btc2);
    btc3 = new Button("blue"); btc3.addActionListener(this); clpnl.add(btc3);
    btc4 = new Button("green"); btc4.addActionListener(this); clpnl.add(btc4);
    btc5 = new Button("yellow"); btc5.addActionListener(this); clpnl.add(btc5);
    btc6 = new Button("purple"); btc6.addActionListener(this); clpnl.add(btc6);

    this.setVisible(true); //可視化
  }

  // ■ メソッド
  // ActionListener を実装しているため、例え内容が空でも必ず記述しなければならない
  public void actionPerformed(ActionEvent e){ // フレーム上で生じたイベントを e で取得
    if (e.getSource() == bt1)      // もしイベントが bt1 で生じたなら
      mc.mode=1;                   // モードを１に
    else if (e.getSource() == bt2) // もしイベントが bt2 で生じたなら
      mc.mode=2;                   // モードを２に
    else if (e.getSource() == bt3) // もしイベントが bt3 で生じたなら
      mc.mode=3;                   // モードを３に
    else if (e.getSource() == bt4) // もしイベントが bt4 で生じたなら
      mc.mode=4;                   // モードを４に
    else if (e.getSource() == bt5)
        mc.mode = 5;
    else if (e.getSource() == bt6)
        mc.mode = 6;
    else if (e.getSource() == bt7){
        mc.clear();
        mc.mode = 7;
    }
    else if (e.getSource() == bt8){
        mc.mode = 8;
    }
    else if(e.getSource() == btc1)
        mc.setcl(Color.BLACK);
    else if(e.getSource() == btc2)
        mc.setcl(Color.RED);
    else if(e.getSource() == btc3)
        mc.setcl(Color.BLUE);
    else if(e.getSource() == btc4)
        mc.setcl(Color.GREEN);
    else if(e.getSource() == btc5)
        mc.setcl(Color.YELLOW);
    else if(e.getSource() == btc6)
        mc.setcl(Color.WHITE);
  }
}

