/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.concorrencia;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ForkBlur extends RecursiveAction {
  private int[] mSource;
  private int mStart;
  private int mLength;
  private int[] mDestination;
  
  private int mBlurWidth = 15; //Processamento tamanho da janela, deve ser ímpar.
  
  public ForkBlur(int[] src, int start, int length, int[] dst) {
    mSource = src;
    mStart = start;
    mLength = length;
    mDestination = dst;
  }
  
  //Média de pixels a partir da fonte, escrevendo resultados no destino.
  protected void computeDirectly() {
    int sidePixels = (mBlurWidth - 1) / 2;
    for (int index = mStart; index < mStart + mLength; index++) {
      // calculando avarage
      float rt = 0, gt = 0, bt = 0;
      for (int mi = -sidePixels; mi <= sidePixels; mi++) {
        int mindex = Math.min(Math.max(mi + index, 0), mSource.length - 1);
        int pixel = mSource[mindex];
        rt += (float)((pixel & 0x00ff0000) >> 16) / mBlurWidth;
        gt += (float)((pixel & 0x0000ff00) >>  8) / mBlurWidth;
        bt += (float)((pixel & 0x000000ff) >>  0) / mBlurWidth;
      }
      
      // Re-montagem do pixel de destino.
      int dpixel = (0xff000000     ) |
                   (((int)rt) << 16) |
                   (((int)gt) <<  8) |
                   (((int)bt) <<  0);
      mDestination[index] = dpixel;
    }
  }
  
  protected static int sThreshold = 10000;
  
  protected void compute() {
    if (mLength < sThreshold) {
      computeDirectly();
      return;
    }
    
    int split = mLength / 2;
    
    invokeAll(new ForkBlur(mSource, mStart,         split,           mDestination),
              new ForkBlur(mSource, mStart + split, mLength - split, mDestination));
  }
  
  // Plumbing follows.
  
  public static void main(String[] args) throws Exception {
    String filename = "red-tulips.jpg";
    File file = new File(filename);
    BufferedImage image = ImageIO.read(file);
    
    new ImageFrame("ForkBlur - original", image);
    
    BufferedImage blurredImage = blur(image);
    
    new ImageFrame("ForkBlur - processed", blurredImage);
  }

  public static BufferedImage blur(BufferedImage srcImage) {
    int w = srcImage.getWidth();
    int h = srcImage.getHeight();
    
    int[] src = srcImage.getRGB(0, 0, w, h, null, 0, w);
    int[] dst = new int[src.length];

    System.out.println("Array size is " + src.length);
    System.out.println("Threshold is " + sThreshold);
    
    int processors = Runtime.getRuntime().availableProcessors();
    System.out.println(Integer.toString(processors) + " processor" +
        (processors != 1 ? "s are " : " is ") + 
        "available");
    
    ForkBlur fb = new ForkBlur(src, 0, src.length, dst);
    
    ForkJoinPool pool = new ForkJoinPool();
    
    long startTime = System.currentTimeMillis();
    pool.invoke(fb);
    long endTime = System.currentTimeMillis();
    
    System.out.println("Image blur took " + (endTime - startTime) + " milliseconds.");
    
    BufferedImage dstImage =
        new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    dstImage.setRGB(0, 0, w, h, dst, 0, w);
  
    return dstImage;
  }
}

class ImageFrame extends JFrame {
  public ImageFrame(String title, BufferedImage image) {
    super(title);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(image.getWidth(), image.getHeight());
    add(new ImagePanel(image));
    setLocationByPlatform(true);
    setVisible(true);
  }    
}


class ImagePanel extends JPanel {
    BufferedImage mImage;

    public ImagePanel(BufferedImage image) {
        mImage = image;
    }

    protected void paintComponent(Graphics g) {
        int x = (getWidth() - mImage.getWidth())/2;
        int y = (getHeight() - mImage.getHeight())/2;
        g.drawImage(mImage, x, y, this);
    }
}
