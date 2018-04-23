import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Jama.*;

@WebServlet("/FaceBackEnd")

public class FaceBackEnd extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    int nop=2500;
    int nopp = 50;
    int pic = 252;
    int mark =pic-100;
    int ekpic = 18;
    int cls=14;
   // URL[] url = new URL[pic + 3];
    URL test;;
    BufferedImage[] image = new BufferedImage[pic + 3];
    BufferedImage imagetest;
// int strt[]={137,182,236,281,326,374,419,467,513,558,603,648,693,738};
 String st[]={"03","04","05","06","07","08","09","10","11","12","13","14","15","16"};
 
    public FaceBackEnd() {
        super();
 
    }
    public void set_proxy(){
    	System.setProperty("http.proxyHost", "192.168.1.107");
    	System.setProperty("http.proxyPort", "3128");
    	final String authUser = "ipg_2014068";
    	final String authPassword = "ritik@02";
    	Authenticator.setDefault(
    			   new Authenticator() {
    			      @Override
    			      public PasswordAuthentication getPasswordAuthentication() {
    			         return new PasswordAuthentication(
    			               authUser, authPassword.toCharArray());
    			      }
    			   }
    			);
    	System.setProperty("http.proxyUser", authUser);
    	System.setProperty("http.proxyPassword", authPassword);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        response.getOutputStream().println("Hurray !! This Servlet Works");
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        try {
       
            int length = request.getContentLength();
            byte[] input = new byte[length];
            ServletInputStream sin = request.getInputStream();
         //   sin.reset();
            int c, count = 0 ;
            while ((c = sin.read(input, count, input.length-count)) != -1) {
                count +=c;
            }
           // sin.reset();
            sin.close();
           // Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.1.107", 3128));
 
           String recStr = new String(input);
         //  set_proxy();
           
          // test =new URL("http://i350.photobucket.com/albums/q410/ritikxman/t5_zpszyl00tit.jpg");
         /*  url[0]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t1_zpscygtd75i.jpg");
           url[1]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t2_zpsaqtp1vw6.jpg");
          url[2]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t3_zpspevlhdn6.jpg");
           url[3]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t4_zpssxut9cge.jpg");
           url[4]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t5_zpszyl00tit.jpg");
           url[5]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t6_zpsjaaokcfn.jpg");
           url[6]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t7_zpsfvdhnwlq.jpg");
           url[7]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t8_zpsewdnjyxf.jpg");
           url[8]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t9_zpsik5dbuy1.jpg");
           url[9]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t10_zpspftnystf.jpg");
            url[10]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t11_zpsidze6nje.jpg");
           url[11]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t12_zpsuxcnbspa.jpg");
           url[pic+2]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/nfd_zps3ou92bsp.png");
           url[12]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t13_zpseisghiat.jpg");
           url[13]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t14_zpsa2gaohf4.jpg");
           url[14]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t15_zpsuwm2clad.jpg");
          
           url[15]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t16_zpsxk8m1090.jpg");
           url[16]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t17_zps95lycxoj.jpg");
                         
           url[17]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t18_zpsfjniwqbk.jpg");
           
           url[18]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t19_zpsgv7thgux.jpg");
           url[19]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t20_zpse92xwfy5.jpg");
           
           url[20]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t21_zpsqievtyii.jpg");
          url[21]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t22_zps82tuygwa.jpg");
           url[22]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t23_zps5klip1th.jpg");
           url[23]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t24_zpstudgsmbf.jpg");
           
           url[24]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t25_zpstdhituc4.jpg");
           url[25]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t26_zpsuu67wwoa.jpg");
           url[26]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t27_zpser4dx4bu.jpg");
           url[27]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t28_zps40bnagug.jpg");
            
           url[28]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t29_zpskauxtenl.jpg");
          url[29]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t30_zpspjp1gfu3.jpg");
           url[30]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t31_zpsdcwwghaw.jpg");
           url[31]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t32_zpswl2darog.jpg");
          url[32]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t33_zpsttktja7w.jpg");
           
           url[33]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t34_zpsonn7zw3s.jpg");
           
           url[34]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t35_zpsoydkjzzb.jpg");
           url[35]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t36_zpsjqguo3mt.jpg");
           
           url[36]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t37_zpskizbocax.jpg");
           url[37]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t38_zpssmll4gml.jpg");
           url[38]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t39_zps15wjixno.jpg");
           
           url[39]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/t40_zpsvkqlubq5.jpg");
           url[pic+1]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/wru_zpsb738dh88.jpg");*/
       /*  
          url[0]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a1_zpsnoizqscs.jpg");
           url[1]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a2_zpsxxzvz2rz.jpg");
          url[2]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a3_zps2gkfo2at.jpg");
           url[3]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a4_zpsprvpiuxe.jpg");
           url[4]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a5_zpsdo2iaenc.jpg");
           url[5]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a6_zpsxajqpcwu.jpg");
           url[6]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a7_zpsh7inayw8.jpg");
           url[7]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a8_zpsmat6ssde.jpg");
           url[8]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a9_zpstf8kog82.jpg");
           url[9]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a10_zpsspd1fcej.jpg");
            url[10]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a11_zpszvfyuqnt.jpg");
           url[11]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a12_zpsxibdpzsg.jpg");
        //   url[pic+2]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/nfd_zps3ou92bsp.png");
           url[12]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a13_zpsv0pnfqnc.jpg");
           url[13]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a14_zpstozbtro3.jpg");
           url[14]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a15_zpslxheania.jpg");
          
           url[15]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a16_zps3gzjh0wk.jpg");
           url[16]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a17_zpsimgjfvus.jpg");
                         
           url[17]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a18_zps8bvaekwb.jpg");
           
           url[18]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a19_zpsovp0pfie.jpg");
           url[19]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a20_zps42i94ktl.jpg");
           
           url[20]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a21_zps7ttkrpjv.jpg");
          url[21]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a22_zpsresbqvie.jpg");
           url[22]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a23_zps9zlpkdvf.jpg");
           url[23]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a24_zpsqtmjyqdx.jpg");
           
           url[24]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a25_zps0pdkdls5.jpg");
           url[25]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a26_zpssjexcasz.jpg");
           url[26]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a27_zpsce1ut0xl.jpg");
           url[27]=new URL("http://i350.photobucket.com/albums/q410/ritikxman/a28_zpsbn3egq6p.jpg");
            
           */
                for(int i=0;i<pic;i++)
     {
    	 image[i] = ImageIO.read(this.getClass().getResource("/"+(i+1)+".JPG"));
          
    	 image[i]=resize(image[i],nopp,nopp);
    	 image[i]=greyscales(image[i]);
       
     }
                    
       
   imagetest = ImageIO.read(this.getClass().getResource("/185.JPG"));
	 imagetest=resize(imagetest,nopp,nopp);
	 imagetest=greyscales(imagetest);
        /*  int bp[] = new int[nop];
            // int bp1[] = new int[nop];
            int k = 0;
            for (int x = 0; x < nopp; x++) {
                for (int y = 0; y < nopp; y++) {
                     int rgb = imagetest.getRGB(x,y);
        	                      //  int red = (rgb >> 16) & 0x000000FF;
        	                        int green = (rgb >>8 ) & 0x000000FF;
                    bp[k] = green;
                    k++;
                }
            }
         StringBuffer bps=new StringBuffer();
         bps.setLength(0);
             String arr[]={"","0","00","000","0000","00000","000000","0000000","00000000","000000000","0000000000","00000000000","000000000000","0000000000000","00000000000000","000000000000000","0000000000000000","00000000000000000","000000000000000000","0000000000000000000","00000000000000000000","000000000000000000000","0000000000000000000000","00000000000000000000000","000000000000000000000000","0000000000000000000000000","00000000000000000000000000","000000000000000000000000000","0000000000000000000000000000","00000000000000000000000000000","000000000000000000000000000000","0000000000000000000000000000000","00000000000000000000000000000000"};
            // String bps="";
            String bin[]=new String[256];

            bin[0]="00000000000000000000000000000000";
            for(int i=1;i<=255;i++)
            {
                int num=i;
                int l=0;
                String s="";
                while(num!=0)
                {
                    l++;
                    s=(num%2)+s;
                    num/=2;


                }
                bin[i]=arr[32-l]+s;


            }

            for(int i=0;i<nop;i++)
            {
                bps.append(bin[bp[i]]);
            }*/
          String ans=    pca(recStr);
          ans+="@";
        ans+=pcaext(recStr);
                                response.setStatus(HttpServletResponse.SC_OK);
                                OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream());
                     
                               
                                writer.write(ans.toString());
                              
                                writer.flush();
                                writer.close();
 
        } catch (IOException e) {
 
 
            try{
            
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().print(e.getMessage());
                response.getWriter().close();
            } catch (IOException ioe) {
            }
        }
        } 
        
        public static BufferedImage resize(BufferedImage img, int newW, int newH) {  
            int w = img.getWidth();  
            int h = img.getHeight();  
            BufferedImage dimg = new BufferedImage(newW, newH, img.getType());  
            Graphics2D g = dimg.createGraphics();  
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
            g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);  
            g.dispose();  
            return dimg;  
            
        }
        
        public String pca(String spic) {
        	//calculating facevector A ={t1,t2,t3....}
        	        int b[][] = new int[nop][pic];
        	        int bt[][] = new int[pic][nop];
        	        int avg[] = new int[nop];
        	        int bb[][] = new int[nop][pic];
        	        double cov[][] = new double[pic][pic];
        	        double evalues[] = new double[pic];

        	        int bp[] = new int[nop];
        	        int bp1[] = new int[nop];
        	        int k = 0;
        	  
        	        int count=0;   for (int i = 0; i < pic; i++) {


        	               
        	                k = 0;

        	                for (int y = 0; y < nopp; y++) {
        	                    for (int x = 0; x < nopp; x++) {
        	                        
        	                        int rgb = image[i].getRGB(y,x);
        	                      //  int red = (rgb >> 16) & 0x000000FF;
        	                        int green = (rgb >>8 ) & 0x000000FF;
        	                        //int blue = (rgb) & 0x000000FF;
        	                        b[k][i] = (green);

        	                        k++;

        	                    }
        	                }
        	        }
        	      

        	        for (int i = 0; i < nop; i++) {
        	            int sum = 0;
        	            for (int j = 0; j < pic; j++) {
        	                sum += (b[i][j]);
        	            }
        	            avg[i] = (sum / pic);
        	        }

        	        // calculating mean centered image for each face image

        	        for (int i = 0; i < nop; i++) {
        	            for (int j = 0; j < pic; j++) {
        	                bb[i][j] = (b[i][j] - avg[i]);

        	            }
        	        }

        	        //transpose of face matrix
        	        for (int i = 0; i < nop; i++) {
        	            for (int j = 0; j < pic; j++) {
        	                bt[j][i] = bb[i][j];
        	            }
        	        }
        	        // creating covariance matrix
        	        cov = multiply(bt, bb);

        	        for(int i=0;i<pic;i++)
        	        {
        	            for(int j=0;j<pic;j++)
        	            {
        	                cov[i][j]/=pic;
        	            }
        	        }

        	        //extracting eigenvalues and eigenvectors

        	        Matrix m = new Matrix(cov);
        	        
        	        EigenvalueDecomposition e = m.eig();
        	        double evectorst[][] = new double[pic][pic];
        	        Matrix evector = e.getV();
        	        Matrix evalue = e.getD();
        	        for (int i = 0; i < pic; i++) {
        	            for (int j = 0; j < pic; j++) {
        	                evectorst[i][j] = evector.get(i, j);///(nop-1);
        	               
        	            }
        	        }
        	        for (int i = 0; i < pic; i++) {
        	            evalues[i] = evalue.get(i, i);
        	           
        	        }
        	        //sorting eigenvalues and their corresponding eigenvectors
        	        for (int i = 0; i < pic - 1; i++) {
        	            for (int j = i + 1; j < pic; j++) {
        	                if (evalues[i] < evalues[j]) {
        	                    double t = evalues[i];
        	                    evalues[i] = evalues[j];
        	                    evalues[j] = t;
        	                    for (int r = 0; r < pic; r++) {
        	                        t = evectorst[r][i];
        	                        evectorst[r][i] = evectorst[r][j];
        	                        evectorst[r][j] = t;//Log.i("evectors",""+evectors1[r][j]);

        	                    }
        	                    
        	                }
        	            }
        	        }


        	        evectorst = normalize1(evectorst, pic, pic);

        	        double evectors1[][] = new double[nop][pic];
        	        //    Log.i("evectors",""+ss1);
        	        evectors1 = multiply(bb, evectorst);
        	        evectors1 = normalize1(evectors1, nop, pic);



        	//        Bitmap compare = Bitmap.createBitmap(nopp, nopp, Bitmap.Config.ARGB_8888);
        	        int num = 0;
        	        // printing egien faces
        	        double tp[][] = new double[nop][pic];
        	        for (int j = 0; j < pic; j++) {
        	            double min = 99999999, max = -99999999;
        	            int maxi = 0, mini = 0;
        	            for (int i = 0; i < nop; i++) {
        	                if (max < evectors1[i][j]) {
        	                    max = evectors1[i][j];
        	                    maxi = i;
        	                }
        	                if (min > evectors1[i][j]) {
        	                    min = evectors1[i][j];
        	                    mini = i;
        	                }
        	            }
        	            tp[maxi][j] = 255;
        	            tp[mini][j] = 0;
        	            for (int i = 0; i < nop; i++) {
        	                if (i != mini && i != maxi) {
        	                    tp[i][j] = 255 * (evectors1[i][j] - min) / (max - min);
        	                }
        	            }
        	        }
        	    

        	        double evectors2t[][] = new double[mark][nop];

        	        for (int i = 0; i < nop; i++) {
        	            for (int j = 0; j < mark; j++) {
        	                evectors2t[j][i] = evectors1[i][j];
        	                //  Log.i("evectors",""+evectors2t[i][j]);
        	            }
        	        }

        	        double ev[][] = new double[nop][mark];
        	        for (int i = 0; i < mark; i++) {
        	            for (int j = 0; j < nop; j++) {
        	                ev[j][i] = evectors2t[i][j];
        	            }
        	        }
        	        double evt[][] = new double[mark][nop];
        	        for (int i = 0; i < nop; i++) {
        	            for (int j = 0; j < mark; j++) {
        	                evt[j][i] = ev[i][j];
        	            }
        	        }
        	        double project[][] = new double[mark][pic];

        	        //finding projection matrix of each face to eigen faces
        	        project = multiply(evt, bb);

        	        //  int k = 0;
        	        k = 0;

    /*       
for(int i=0;i<(32*nop);i+=32)
{
	bp[k]=Integer.parseInt(spic.substring(i,i+32),2);
	k++;
}
     */ 	 /* int bpoext[][]=new int[nopp][nopp];
        	        int bpext[][]=new int[nopp][nopp];
        	        int bpooext[][]=new int[nopp][nopp];
        	        for (int y = nopp - 1; y >= 0; y--) {
        	            for (int x = 0; x < nopp; x++) {
        	            	int rgb = imagetest.getRGB(y,x);
  	                      //  int red = (rgb >> 16) & 0x000000FF;
  	                        int green = (rgb >>8 ) & 0x000000FF;
  	                        //int blue = (rgb) & 0x000000FF;
        	                bpoext[x][y] = (green);
        	                //  k++;


        	            }
        	        }
        	        for(int x=0;x<nopp;x++)
        	        {
        	            for(int y=0;y<nopp;y++)
        	            {
        	                bpooext[y][x]=bpoext[x][y];
        	            }
        	        }

        	        for(int x=0;x<nopp;x++)
        	        {
        	            for(int y=0;y<nopp;y++)
        	            {
        	                bpext[nopp-x-1][y]=bpooext[x][y];
        	            }
        	        }
        	        k=0;
        	        for(int x=0;x<nopp;x++)

        	        {
        	            for(int j=0;j<nopp;j++)
        	            {
        	                bp[k]=bpext[x][j];
        	                k++;
        	            }
        	        }*/
        	     k=0;
        	        for (int x= 0; x<nopp;x++) {
        	            for (int y = 0; y < nopp; y++) {
        	            	int rgb = imagetest.getRGB(x,y);
  	                      //  int red = (rgb >> 16) & 0x000000FF;
  	                        int green = (rgb >>8 ) & 0x000000FF;
  	                        //int blue = (rgb) & 0x000000FF;
        	               bp[k] = (green);
        	                  k++;


        	            }
        	        }
   

        	        // subtracting face vector of test image by average vector
        	        for (int i = 0; i < nop; i++) {
        	            bp1[i] = (bp[i] - avg[i]);
        	        }

        	        double testproject[][] = new double[mark][1];
        	        int bp1t[][] = new int[nop][1];
        	        for (int i = 0; i < nop; i++) {
        	            bp1t[i][0] = bp1[i];
        	        }

        	        // reconstruction of trainging image using eigen faces and projection matrix
        	        double recon[][] = new double[nop][pic];
        	        recon = multiply(ev, project);
        	        for (int i = 0; i < pic; i++) {
        	            for (int j = 0; j < nop; j++) {
        	                recon[j][i] += avg[j];
        	            }
        	        }
        	        num = 0;
        	        for (int i = 0; i < nopp; i++) {
        	            for (int j = 0; j < nopp; j++) {
        	                double x = recon[num][2];
        	                num++;
        	                //     compare.setPixel(i, j, Color.argb(255, (int)x, (int)x, (int)x));
        	            }
        	        }

        	        //   ImageView.setImageBitmap(compare);


        	// projection vector of test image onto eigen faces

        	        testproject = multiply(evt, bp1t);
        	        double threshold = 0, max = -99999999;

        	        //calculating threshold value Qc
        	        for (int i = 0; i < pic - 1; i++) {
        	            for (int j = i + 1; j < pic; j++) {
        	                double sum = 0;
        	                for (int r = 0; r < mark; r++) {
        	                    // if (project[r][i] > project[r][j])
        	                    sum += Math.abs(project[r][i] - project[r][j]);
        	                    //   else
        	                    //      sum += project[r][j] - project[r][i];


        	                }

        	                if (max < sum)
        	                    max = sum;
        	            }
        	        }
        	        max = 0.5 * max;
        	        //max=2200;
        	   //     Log.i("evectors", "" + max);

        	        int ans = 0;
        	         /*   for(int i=0;i<mark;i++)
        	            {
        	                for(int j=0;j<pic;j++)
        	                {
        	                  //  Log.i("evectors",""+project[i][j]);
        	                }
        	            }
        	*/
        	        double min = 999999999;
        	       
        	        for (int i = 0; i < pic; ) {
        	            double sum[] = new double[mark];
        	            for (int j = 1; j <= ekpic; j++) {
        	                for (int ii = 0; ii < mark; ii++) {
        	                    sum[ii] += project[ii][i];

        	                }
        	                i++;
        	            }
        	            for (int j = 0; j < mark; j++)
        	                sum[j] /= ekpic;
        	            //sum=Math.sqrt(sum);
        	            double sums = 0.0;
        	            for (int j = 0; j < mark; j++) {
        	                sums += ((testproject[j][0] - sum[j])) * ((testproject[j][0] - sum[j]));
        	            }
        	            // Log.i("evectors",""+sum);
        	            sums = Math.sqrt(sums);
        	            if (min > sums) {
        	                min = sums;
        	                ans = i - 1;
        	            }
        	        }

        	        double ee = 0, sum = 0;
        	        //reconstruction of testimage using projection matrix
        	        double recontest[][] = new double[nop][1];
        	        recontest = multiply(ev, testproject);
        	        for (int i = 0; i < nop; i++) {
        	            recontest[i][0] += avg[i];
        	        }

        	        num = 0;
        	        for (int i = 0; i < nopp; i++) {
        	            for (int j = 0; j < nopp; j++) {
        	                double x = recontest[num][0];
        	                num++;
        	              //  compare.setPixel(i, j, Color.argb(255, (int) x, (int) x, (int) x));
        	            }
        	        }

        	      //  ImageView.setImageBitmap(compare);


        	        sum = 0;
        	        for (int i = 0; i < nop; i++) {
        	            sum += (bp[i] - recontest[i][0]) * (bp[i] - recontest[i][0]);
        	        }
        	        ee = Math.sqrt(sum);
        	   //     String ss[] = {"Sub03","Sub09","Sub05","Sub08","Sub07","Sub06"}; 
        	      /*  String ss[] = {"chacha","chacha","chacha","chacha","somu","somu","somu","somu","pengu","pengu","pengu","pengu","sachin","sachin","sachin","sachin","chandak","chandak","chandak","chandak",
"arpit","arpit","arpit","arpit","ritik","ritik","ritik","ritik"};*/
        	        
        	      //  String ss[] = {
        	       // 	"KV Arya Sir","KV Arya Sir","KV Arya Sir","KV Arya Sir","KV Arya Sir","KV Arya Sir","KV Arya Sir","KV Arya Sir","Ritik","Ritik","Ritik","Ritik","Ritik","Ritik","Ritik","Ritik",};
        	        		//"A","A","A","A","A","A","A","A","A","A","B","B","B","B","B","B","B","B","B","B","C","C","C","C","C","C","C","C","C","C","D","D","D","D","D","D","D","D","D","D","E","E","E","E","E","E","E","E","E","E",};
        	        //    "shweta", "shweta", "shweta", "shweta", "shweta", "shweta", "shweta", "shweta", "shweta", "shweta", "papa", "papa", "papa", "papa", "papa", "papa", "papa", "papa", "papa", "papa", "ritik", "ritik", "ritik", "ritik", "ritik", "ritik", "ritik", "ritik", "ritik", "ritik", "mummy", "mummy", "mummy", "mummy", "mummy", "mummy", "mummy", "mummy", "mummy", "mummy"};
        	    //    String ss[] = {"Sub03","Sub03","Sub03","Sub03","Sub03","Sub03","Sub03","Sub03","Sub03","Sub03","Sub04","Sub04","Sub04","Sub04","Sub04","Sub04","Sub04","Sub04","Sub04","Sub04","Sub05","Sub05","Sub05","Sub05","Sub05","Sub05","Sub05","Sub05","Sub05","Sub05","Sub08","Sub08","Sub08","Sub08","Sub08","Sub08","Sub08","Sub08","Sub08","Sub08","Sub07","Sub07","Sub07","Sub07","Sub07","Sub07","Sub07","Sub07","Sub07","Sub07","Sub06","Sub06","Sub06","Sub06","Sub06","Sub06","Sub06","Sub06","Sub06","Sub06",};
        	int kkk=0;  
                String ss[]=new String[ekpic*cls+5];
                for(int i=0;i<cls;i++)
                   {
                       for(int j=0;j<ekpic;j++)
                       {
                           ss[kkk]=st[i];
                           kkk++;
                       }
                       
                   }

//  Log.i("evectors", "" + ee);
        	       // Log.i("evectors", "" + min);
        	       // Log.i("evectors", "" + ans);
        	        //  max=4000;
        	        double max1 = 6500;
        	        max = 6100;
        	        if (ee < max1) {


        	            if (min < max) {
        	               
        	                return ("Algo 1 =" + ss[ans] + " " +" "+kkk);
        	               
        	            } else {
        	               
        	               return ("Algo 1= none " + (int)min+" but can be "+ss[ans]);
        	                //  ImageView.setImageBitmap(bitmap[pic + 1]);
        	            }
        	        } else {
        	            
        	            return ("Algo 1= Not Even a Face! " + (int)ee+"  but can be "+ss[ans]);
        	            //  ImageView.setImageBitmap(bitmap[pic+2]);
        	        }


        	    }



        public static BufferedImage greyscales(BufferedImage original) {
          // Buffered finalImage = Bitmap.createBitmap(original.getWidth(), original.getHeight(), original.getConfig());
            int A, R, G, B;
            int pixelColor;
            int height = original.getHeight();
            int width = original.getWidth();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    
                   
                 
                    int rgb = original.getRGB(x,y);
                    int alpha = (rgb >> 24) & 0x000000FF;
                    int red = (int)(((rgb >> 16) & 0x000000FF)*0.299);
                    int green = (int)(((rgb >>8 ) & 0x000000FF)*0.587);
                    int blue = (int)(((rgb) & 0x000000FF)*0.114);
                    int col = (alpha << 24) | ((red+blue+green) << 16) | ((red+blue+green) << 8) | (red+blue+green);
                    original.setRGB(x, y, col);

                }
            }
            return original;
        }


        public static double[][] multiply(int[][] a, int[][] b) {
            int rowsInA = a.length;
            int columnsInA = a[0].length; // same as rows in B
            int columnsInB = b[0].length;
            double[][] c = new double[rowsInA][columnsInB];
            for (int i = 0; i < rowsInA; i++) {
                for (int j = 0; j < columnsInB; j++) {
                    for (int k = 0; k < columnsInA; k++) {
                        c[i][j] = c[i][j] + a[i][k] * b[k][j];
                    }
                }
            }
            return c;
        }



        public static double[][] multiply(double[][] a, byte[][] b) {
            int rowsInA = a.length;
            int columnsInA = a[0].length; // same as rows in B
            int columnsInB = b[0].length;
            double[][] c = new double[rowsInA][columnsInB];
            for (int i = 0; i < rowsInA; i++) {
                for (int j = 0; j < columnsInB; j++) {
                    for (int k = 0; k < columnsInA; k++) {
                        c[i][j] = c[i][j] + a[i][k] * b[k][j];
                    }
                }
            }
            return c;
        }


        public static double[][] multiply(int[][] a, double[][] b) {
            int rowsInA = a.length;
            int columnsInA = a[0].length; // same as rows in B
            int columnsInB = b[0].length;
            double[][] c = new double[rowsInA][columnsInB];
            for (int i = 0; i < rowsInA; i++) {
                for (int j = 0; j < columnsInB; j++) {
                    for (int k = 0; k < columnsInA; k++) {
                        c[i][j] = c[i][j] + a[i][k] * b[k][j];
                    }
                }
            }
            return c;
        }

        public static double[][] multiply(double[][] a, int[][] b) {
            int rowsInA = a.length;
            int columnsInA = a[0].length; // same as rows in B
            int columnsInB = b[0].length;
            double[][] c = new double[rowsInA][columnsInB];
            for (int i = 0; i < rowsInA; i++) {
                for (int j = 0; j < columnsInB; j++) {
                    for (int k = 0; k < columnsInA; k++) {
                        c[i][j] = c[i][j] + a[i][k] * b[k][j];
                    }
                }
            }
            return c;
        }

        public static double[][] multiply(double[][] a, double[][] b) {
            int rowsInA = a.length;
            int columnsInA = a[0].length; // same as rows in B
            int columnsInB = b[0].length;
            double[][] c = new double[rowsInA][columnsInB];
            for (int i = 0; i < rowsInA; i++) {
                for (int j = 0; j < columnsInB; j++) {
                    for (int k = 0; k < columnsInA; k++) {
                        c[i][j] = c[i][j] + a[i][k] * b[k][j];
                    }
                }
            }
            return c;
        }

        public static double[][] normalize(double[][] a, int n, int m, double[] e) {
            double b[][] = new double[n][m];
            for (int i = 0; i < m; i++) {
                double sum = 0.0;

                for (int j = 0; j < n; j++) {
                    b[j][i] = a[j][i] / (Math.sqrt(e[i]));
                }
            }
            return b;
        }

        public static double[][] normalize1(double[][] a, int n, int m) {
            double b[][] = new double[n][m];
            for (int i = 0; i < m; i++) {
                double sum = 0.0;
                for (int j = 0; j < n; j++) {
                    sum += (a[j][i] * a[j][i]);
                }
                sum = Math.sqrt(sum);
                for (int j = 0; j < n; j++) {
                    b[j][i] = a[j][i] / sum;
                }
            }
            return b;
        }
       
        ///EXTENDED 2D PCA!!!

        public String pcaext(String spicext) {
         
    int imm[][]=new int[nopp][nopp*pic];
            int k = 0,count=0;
            for (int i = 0; i < pic; i++) {


            
                k = 0;

                for (int y = 0; y < nopp; y++) {
                    for (int x = 0; x < nopp; x++) {
                    	int rgb = image[i].getRGB(y,x);
	                      //  int red = (rgb >> 16) & 0x000000FF;
	                        int green = (rgb >>8 ) & 0x000000FF;
	                        //int blue = (rgb) & 0x000000FF;
      	               
      	                //  k++;

                        imm[y][x+i*nopp] = (green);




                    }
                }
            }
         //   Log.i("evectors",""+ count);
          //  Log.i("evectors",imm[99][3999]+"");
            double sum=0;k=0;
            //average face matrix
            double avgext[][]=new double[nopp][nopp];

                for (int x = 0; x < nopp; x++) {

                    for (int y = 0 ;y < (nopp); y++) {
                        sum=0;
                        for(int i=0;i<pic;i++)
                        {
                           sum+=imm[x][y+i*nopp];
                        }
    avgext[x][y]=sum/pic;
                         //   Log.i("evectors",""+avgext[x][y]);
                    }

                }

    double bbext[][]=new double[nopp][nopp*pic];

            for (int x = 0; x < nopp; x++) {

                for (int y = 0 ;y < (nopp); y++) {

                    for(int i=0;i<pic;i++)
                    {
                    bbext[x][y+i*nopp]=   imm[x][y+i*nopp]-avgext[x][y];
                        //if(bbext[x][y+i*nopp]<0)
                       // Log.i("evectors",""+bbext[y+i*nopp][x]);

                    }

                }

            }

    double bextt[][]=new double[nopp*pic][nopp];
            //transpose of face matrix
            for(int i=0;i<pic;i++)
            {
                for(int x=0;x<nopp;x++)
                {
                    for(int y=0;y<(nopp);y++)
                    {
                        bextt[y+i*nopp][x]=bbext[x][y+i*nopp];

                    }
                }
            }

    double covh[][]=new double[nopp][nopp];
            covh=multiply(bbext,bextt);

    for(int i=0;i<nopp;i++)
    {
        for(int j=0;j<nopp;j++)
        {
            covh[i][j]/=pic;// if(i==j)Log.i("evectors",""+cov[i][j]);
        }
    }


            Matrix m = new Matrix(covh);
            EigenvalueDecomposition e = m.eig();
            double evectorsext[][] = new double[nopp][nopp];
            Matrix evector = e.getV();
            Matrix evalue = e.getD();
            for (int i = 0; i < nopp; i++) {
                for (int j = 0; j < nopp; j++) {
                    evectorsext[i][j] = evector.get(i, j);///(nop-1);
                    // Log.i("evectors",""+evectorst[i][j]);
                }
            }
            double evaluesext[]=new double[nopp];
            for (int i = 0; i < nopp; i++) {
                evaluesext[i] = evalue.get(i, i);
                // Log.i("evectors",""+evalues[i]);
            }
            //sorting eigenvalues and their corresponding eigenvectors
            for (int i = 0; i < nopp - 1; i++) {
                for (int j = i + 1; j < nopp; j++) {
                    if (evaluesext[i] < evaluesext[j]) {
                        double t = evaluesext[i];
                        evaluesext[i] = evaluesext[j];
                        evaluesext[j] = t;
                        for (int r = 0; r < nopp; r++) {
                            t = evectorsext[r][i];
                            evectorsext[r][i] = evectorsext[r][j];
                            evectorsext[r][j] = t;//Log.i("evectors",""+evectors1[r][j]);

                        }
                        //    Log.i("evectors",""+evectors1[i][j]);
                    }
                }
            }


            evectorsext = normalize1(evectorsext, nopp, nopp);


    double classavg[][][]=new double[cls][nopp][nopp];
    int ii=0,jj=0;
            for(int i=0;i<pic;i+=ekpic)
            {

                   for(int x=0;x<nopp;x++)
                   {
                       jj=0;
                       for(int j=i*nopp;j<(i*nopp+nopp);j++)
                       {
                           sum=0;

                          for( k=j;k<((i+ekpic)*nopp);k+=nopp)
                          {
                              sum+=imm[x][k];
                          }
                           sum/=ekpic;
                           classavg[i/ekpic][x][jj]=sum;jj++;
                       }

                   }



            }
            double evectorsextt[][]=new double[nopp][nopp];
            for(int i=0;i<nopp;i++)
            {
                for(int j=0;j<nopp;j++)
                {
                    evectorsextt[j][i]=evectorsext[i][j];
                }
            }

            double cb[][][]=new double[cls][nopp][nopp];
    for(int i=0;i<cls;i++) {
        cb[i] = multiply(evectorsextt,classavg[i]);
    }

               // rb = normalize1(rb, nopp, pic);
    int bpoext[][]=new int[nopp][nopp];
            int bpext[][]=new int[nopp][nopp];
            int bpooext[][]=new int[nopp][nopp];
          //  return ("no ans got yrr");

            int sumyo=0;
//return (""+spicext.length());

        int i2=0,j2=0;
        int i1=0,j1=0;
        for( i2=0;i2<32*nop;i2+=32)
        {
        	
        	
        		bpext[i1][j1]=Integer.parseInt(spicext.substring(i2,i2+32),2);
        		//sumyo+=bpext[i1][j1];
        		j1++;
        		//i1++;
        		if(j1>=nopp)
        			{i1++;
        			j1=0;
        			}
        			
        		
        
        	if(i1>nopp||j1>nopp)
        		break;
        }
     //   return (""+(sumyo/10000));
     
   /*     for (int x= 0; x<nopp;x++) {
            for (int y = 0; y < nopp; y++) {
            	int rgb = imagetest.getRGB(x,y);
                //  int red = (rgb >> 16) & 0x000000FF;
                  int green = (rgb >>8 ) & 0x000000FF;
                  //int blue = (rgb) & 0x000000FF;
               bpext[x][y] = (green);
                 // k++;


            }
        }

*/

         
            double cbtest[][]=new double[nopp][nopp];
            cbtest=multiply(evectorsextt,bpext);
        //    rbtest=normalize1(rbtest,nopp,pic);


            int imm1[][]=new int[nopp*pic][nopp];
            k = 0;
            for (int i = 0; i < pic; i++) {



                for (int y = 0; y < nopp; y++) {
                    for (int x = 0; x < nopp; x++) {
                    	int rgb = image[i].getRGB(y,x);
	                      //  int red = (rgb >> 16) & 0x000000FF;
	                        int green = (rgb >>8 ) & 0x000000FF;
	                        //int blue = (rgb) & 0x000000FF;
    	               
    	                //  k++;

                     

                        imm1[i*nopp+y][x]=(green);

                    }
                }
            }
             sum=0;k=0;
            //average face matrix
            double avgext1[][]=new double[nopp][nopp];

            for (int x = 0; x < nopp; x++) {

                for (int y = 0 ;y < (nopp); y++) {
                    sum=0;
                    for(int i=0;i<pic;i++)
                    {
                        sum+=imm1[i*nopp+x][y];
                    }
                    avgext1[x][y]=sum/pic;
                }

            }

            double bbext1[][]=new double[nopp*pic][nopp];

            for (int x = 0; x < nopp; x++) {

                for (int y = 0 ;y < (nopp); y++) {

                    for(int i=0;i<pic;i++)
                    {
                        bbext1[x+i*nopp][y]=   imm1[x+i*nopp][y]-avgext1[x][y];
                    }

                }

            }

            double bextt1[][]=new double[nopp][nopp*pic];
            //transpose of face matrix
            for(int i=0;i<pic;i++)
            {
                for(int x=0;x<nopp;x++)
                {
                    for(int y=0;y<(nopp);y++)
                    {
                        bextt1[y][x+i*nopp]=bbext1[x+i*nopp][y];
                    }
                }
            }

            double covg[][]=new double[nopp][nopp];
            covg=multiply(bextt1,bbext1);

            for(int i=0;i<nopp;i++)
            {
                for(int j=0;j<nopp;j++)
                {
                    covg[i][j]/=pic;
                }
            }


            Matrix m1 = new Matrix(covg);
            EigenvalueDecomposition e1 = m1.eig();
            double evectorsext1[][] = new double[nopp][nopp];
            Matrix evector1 = e1.getV();
            Matrix evalue1 = e1.getD();
            for (int i = 0; i < nopp; i++) {
                for (int j = 0; j < nopp; j++) {
                    evectorsext1[i][j] = evector1.get(i, j);///(nop-1);
                    // Log.i("evectors",""+evectorst[i][j]);
                }
            }
            double evaluesext1[]=new double[nopp];
            for (int i = 0; i < nopp; i++) {
                evaluesext1[i] = evalue1.get(i, i);
                // Log.i("evectors",""+evalues[i]);
            }
            //sorting eigenvalues and their corresponding eigenvectors
            for (int i = 0; i < nopp - 1; i++) {
                for (int j = i + 1; j < nopp; j++) {
                    if (evaluesext1[i] < evaluesext1[j]) {
                        double t = evaluesext1[i];
                        evaluesext1[i] = evaluesext1[j];
                        evaluesext1[j] = t;
                        for (int r = 0; r < nopp; r++) {
                            t = evectorsext1[r][i];
                            evectorsext1[r][i] = evectorsext1[r][j];
                            evectorsext1[r][j] = t;//Log.i("evectors",""+evectors1[r][j]);

                        }
                        //    Log.i("evectors",""+evectors1[i][j]);
                    }
                }
            }

            evectorsext1 = normalize1(evectorsext1, nopp, nopp);

            double classavg1[][][]=new double[cls][nopp][nopp];
            ii=0;jj=0;
            for(int i=0;i<pic;i+=ekpic)
            {
    jj=0;
                for(int x=i*nopp;x<(i*nopp+nopp);x++)
                {

                    for(int j=0;j<(nopp);j++)
                    {
                        sum=0;

                        for( k=x;k<((i+ekpic)*nopp);k+=nopp)
                        {
                            sum+=imm1[k][j];
                        }
                        sum/=ekpic;
                        classavg1[i/ekpic][jj][j]=sum;
                    }
    jj++;
                }



            }


            double rb[][][]=new double[cls][nopp][nopp];
            for(int i=0;i<cls;i++) {
                rb[i] = multiply(classavg1[i],evectorsext1);
            }



            double rbtest[][]=new double[nopp][nopp];
            rbtest=multiply(bpext,evectorsext1);
            double rmin=1000000000;int rmini=0;
    for(int i=0;i<cls;i++)
    {
        sum=0;
        for(int x=0;x<nopp;x++)
        {
            for(int y=0;y<nopp;y++)
            {
               sum+=((rb[i][y][x]-rbtest[y][x])*(rb[i][y][x]-rbtest[y][x]));
            }
        }
    sum=Math.sqrt(sum);
        if(rmin>sum)
        {
            rmin=sum;
            rmini=i;
        }
    }
    double cmin=1000000000;int cmini=0;
            for(int i=0;i<cls;i++)
            {
                sum=0;
                for(int x=0;x<nopp;x++)
                {
                    for(int y=0;y<nopp;y++)
                    {
                        sum+=((cb[i][x][y]-cbtest[x][y])*(cb[i][x][y]-cbtest[x][y]));
                    }
                }
                sum=Math.sqrt(sum);
                if(cmin>sum)
                {
                    cmin=sum;
                    cmini=i;
                }
            }




         //   String ss[] = {"chacha","somu","pengu","sachin","chandak","arpit","ritik"};
      //     String ss[] = {"shweta","papa","ritik","mummy"};     
         //String ss[]={"A","B","C","D","E"};
          // String ss[]={"KV Arya Sir","Ritik"};
        //   String ss[] = {"Sub03","Sub04","Sub05","Sub08","Sub07","Sub06"}; 
         String ss[]={"03","04","05","06","07","08","09","10","11","12","13","14","15","16"};
            if(rmin<8000&&cmin<8000)
              return("Algo 2=  "+ss[rmin<=cmin?rmini:cmini]+" "+(int)rmin);
            else
               return("Algo 2= none but can be "+ss[rmin<=cmin?rmini:cmini]+" "+(int)rmin);
        //  int  num = 0;
           // Bitmap compare = Bitmap.createBitmap(nopp, nopp, Bitmap.Config.ARGB_8888);
         





        }

   
    
 
}