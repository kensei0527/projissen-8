import java.awt.*;
import java.awt.event.*;

class MyCanvas2 extends Canvas implements MouseListener, MouseMotionListener {
  // ■ フィールド変数
  int x, y;   // mouse pointer position
  int px, py; // preliminary position
  int cx, cy; //中心座標
  int ow, oh; // width and height of the object
  int cw, ch; //半径（幅）と（高さ）
  int mode;   // drawing mode associated as below
  Image img = null;   // 仮の画用紙
  Graphics gc = null; // 仮の画用紙用のペン
  Dimension d; // キャンバスの大きさ取得用

  // ■ コンストラクタ
  MyCanvas2(DrawingApli00 obj){
    mode=0;                       // initial value 
    int imgW = 1000;
    int imgH = 700;
    this.setSize(imgW,imgH);        // キャンバスのサイズを指定
    addMouseListener(this);       // マウスのボタンクリックなどを監視するよう指定
    addMouseMotionListener(this); // マウスの動きを監視するよう指定
  }

  // ■ メソッド（オーバーライド）
  // フレームに何らかの更新が行われた時の処理
  public void update(Graphics g) {
    paint(g); // 下記の paint を呼び出す
  }

  // ■ メソッド（オーバーライド）
  public void paint(Graphics g) {
    d = getSize();   // キャンバスのサイズを取得
    if (img == null) // もし仮の画用紙の実体がまだ存在しなければ
      img = createImage(d.width, d.height); // 作成
    if (gc == null){  // もし仮の画用紙用のペン (GC) がまだ存在しなければ
      gc = img.getGraphics(); // 作成
      gc.setColor(Color.white);
      gc.fillRect(0, 0, d.width, d.height);
      gc.setColor(Color.black);
    }
      

    switch (mode){
    case 1: // モードが１の場合
      gc.drawLine(px, py, x, y); // 仮の画用紙に描画
      break;
    case 2: // モードが２の場合
      gc.drawLine(px, py, x, y); // 仮の画用紙に描画
      break;
    case 3: // モードが３の場合
      gc.drawRect(px, py, ow, oh); // 仮の画用紙に描画
      break;
    case 4: // モードが４の場合
      gc.drawOval(px, py, ow, oh); // 仮の画用紙に描画
      break;
    case 5:
        gc.fillOval(px, py, ow, oh);
        break;
    case 6:
        gc.fillRect(px, py, ow, oh);
        break;
    case 7:
        gc.clearRect(0, 0, d.width, d.height);
        gc.setColor(Color.white);
        gc.fillRect(0, 0, d.width, d.height);
        break;
    case 8:
      gc.setColor(Color.white);
      gc.fillOval(x-5, y-5, 10, 10);
    }
    g.drawImage(img, 0, 0, this); // 仮の画用紙の内容を MyCanvas に描画
  }

  void clear(){
    gc.clearRect(0, 0, d.width, d.height);
    gc.setColor(Color.white);
    gc.fillRect(0, 0, d.width, d.height);
    repaint();
  }

  void setcl(Color c){
    gc.setColor(c);
  }

  // ■ メソッド
  // 下記のマウス関連のメソッドは，MouseListener をインターフェースとして実装しているため
  // 例え使わなくても必ず実装しなければならない
  public void mouseClicked(MouseEvent e){}// 今回は使わないが、無いとコンパイルエラー
  public void mouseEntered(MouseEvent e){}// 今回は使わないが、無いとコンパイルエラー
  public void mouseExited(MouseEvent e){} // 今回は使わないが、無いとコンパイルエラー
  public void mousePressed(MouseEvent e){ // マウスボタンが押された時の処理
    switch (mode){
    case 1: // mode が１の場合，次の内容を実行する
      x = e.getX();
      y = e.getY();
      break;
    case 2: // mode が２もしくは
    case 3: // ３もしくは
    case 4: // ４の場合，次の内容を実行する
    case 5:
    case 6:
      px = e.getX();
      py = e.getY();
      break;
    case 8:
      x = e.getX();
      y = e.getY();
      repaint();
      break;
    }
  }
  public void mouseReleased(MouseEvent e){ // マウスボタンが離された時の処理
    switch (mode){
    case 2: // mode が２もしくは
    case 3: // ３もしくは
    case 4: // ４の場合，次の内容を実行する
    case 5:
    case 6:
    case 7:
      x = e.getX();
      y = e.getY();
      cx = (x+px)/2;
      cy = (y+py)/2;
      
      if(px < x && py > y){
        ch = py - cy;
        py = y;
        y = y + (ch * 2);
      }
      ow = x-px;
      oh = y-py;
      repaint(); // 再描画
      break;
    } 
  }

  // ■ メソッド
  // 下記のマウス関連のメソッドは，MouseMotionListener をインターフェースとして実装しているため
  // 例え使わなくても必ず実装しなければならない
  public void mouseDragged(MouseEvent e){ // マウスがドラッグされた時の処理
    switch (mode){
    case 1: // mode が１の場合，次の内容を実行する
      px = x;
      py = y;
      x = e.getX();
      y = e.getY();
      repaint(); // 再描画
      break;
    /*case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
      x = e.getX();
      y = e.getY();
      /*cx = (x+px)/2;
      cy = (y+py)/2;
      if(px < x && py > y){
        ch = py - cy;
        py = y;
        y = y + (ch * 2);
      }
      ow = x-px;
      oh = y-py;
      repaint();
      break;*/
      case 8:
        x = e.getX();
        y = e.getY();
        repaint();
        break;
    }
  }
  public void mouseMoved(MouseEvent e){} // 今回は使わないが、無いとコンパイルエラー
}
