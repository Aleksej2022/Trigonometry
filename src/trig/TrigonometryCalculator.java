package trig;


import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Scanner;

public class TrigonometryCalculator extends JFrame {
    private MyCanvas canvas = new MyCanvas();
    static JFrame j = new JFrame();
    static Scanner text = new Scanner(System.in);
    static Scanner number = new Scanner(System.in);
    static String user_choice;
    static String name;
    static double result;
    static String side_given;
    static String sideToBeFound;
    static String angle;
    static double theta;
    static String firstSide;
    static String secondSide;
    static String status;
    static String path;
    static String questionNumber;
    static Document document;
    static PdfWriter writer;
    static String user_response;

    public TrigonometryCalculator(){
        canvas.setBackground(Color.WHITE);
        j.add(canvas);
        j.setLayout(new BorderLayout());
        j.setSize(900,450);
        j.setTitle("Trigonometric Calculator");
        j.add("Center", canvas);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setResizable(false);
    }

    private class MyCanvas extends Canvas{
        public void paint(Graphics g){
            g.setColor(Color.MAGENTA);
            g.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD,20));
            g.drawString(name + ", the result is: ->",250,25 );
            java.awt.Image img2 = new ImageIcon("C:\\Users\\m\\Downloads\\Lesson 19 Materials\\triangle.png").getImage();
            g.drawImage(img2,200,30,this);
            g.setColor(Color.RED);
            g.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD,20));

            // The section below is for finding a missing side of a right angle triangle

            if (status.equals("first")){
                // sin(SOH) Sin theta = Opposite/Hypotenuse to find the missing side of the right triangle
                if (side_given.equals("H") && sideToBeFound.equals("O")){ //Sin theta = O/H = Sin theta * hypotenuse
                    System.out.println("Enter the hypotenuse side value");
                    double hypotenuse = number.nextDouble();
                    String hyp = Double.toString(hypotenuse);
                    System.out.println("Below is the picture of the right angle triangle");
                    g.drawString(hyp,480,200);//this value will be placed on the hypotenuse
                    g.drawString(angle,520,300);//this angle value will be placed on the down corner of the right angle
                    g.drawString("The solution is: -> Opposite side " +  "= " + "Sin Theta" + "x" + hypotenuse,200,380);
                    result = Math.sin(Math.toRadians(theta)) * hypotenuse;

                    DecimalFormat df = new DecimalFormat("#.#");
                    String res = df.format(result);
                    System.out.println(COLORS.RED + "**********************************************************************************************");
                    System.out.println("The opposite side value of the right angle triangle is: -> " + res);
                    System.out.println("**********************************************************************************************");
                    g.drawString(res,170,200);//this places the opposite side value on the opposite side of the right angle

                }
                else if (side_given.equals("O") && sideToBeFound.equals("H")) {
                    System.out.println(COLORS.RESET + "Enter the opposite side value");
                    double opps = number.nextDouble();
                    String opp = Double.toString(opps);
                    System.out.println("Below is the picture of the right angle triangle");
                    g.drawString(opp, 170, 200);//this value will be placed on the opposite side
                    g.drawString(angle, 520, 300);//this angle value will be placed on the down corner of the right angle
                    g.drawString("The solution is: -> Sin " + theta + "= " + opps + "/" + sideToBeFound, 200, 380);
                    result =opps /  Math.sin(Math.toRadians(theta)); //SOH = 0/H

                    DecimalFormat df = new DecimalFormat("#.#");
                    String res = df.format(result);
                    System.out.println(COLORS.RED + "**********************************************************************************************");
                    System.out.println("The hypotenuse side value of the right angle triangle is: -> " + res);
                    System.out.println("**********************************************************************************************");
                    g.drawString(res, 480, 200);//this places the opposite side value on the opposite side of the right angle
                }
                // Using the cosine trigonometric ratio Cos theta =  A/H = H = Cos theta / A

                else if (side_given.equals("A") && sideToBeFound.equals("H")) {
                    System.out.println(COLORS.RESET + "Enter the adjacent side value");
                    double adja = number.nextDouble();
                    String adjace = Double.toString(adja);
                    System.out.println("Below is the picture of the right angle triangle");
                    g.drawString(adjace, 400, 350);//this value will be placed on the adjacent side
                    g.drawString(angle, 520, 300);//this angle value will be placed on the down corner of the right angle
                    g.drawString("The solution is: -> Cos " + theta + "= " + adja + "/" + sideToBeFound, 200, 380);
                    result =adja /  Math.cos(Math.toRadians(theta)); //SOH = 0/H

                    DecimalFormat df = new DecimalFormat("#.#");
                    String res = df.format(result);
                    System.out.println(COLORS.RED + "**********************************************************************************************");
                    System.out.println("The hypotenuse side value of the right angle triangle is: -> " + res);
                    System.out.println("**********************************************************************************************");
                    g.drawString(res, 480, 200);//this places the opposite side value on the opposite side of the right angle
                }
                // Cos theta = A / H = Cos theta * hypotenuse
                else if (side_given.equals("H") && sideToBeFound.equals("A")) {
                    System.out.println(COLORS.RESET + "Enter the hypotenuse side value");
                    double hypotenuse = number.nextDouble();
                    String hypo  = Double.toString(hypotenuse);
                    System.out.println("Below is the picture of the right angle triangle");
                    g.drawString(hypo, 480, 200);//this value will be placed on the hypotenuse
                    g.drawString(angle, 520, 300);//this angle value will be placed on the down corner of the right angle
                    g.drawString("The solution is: -> Adjacent side " +  "= " + "Cos theta " + "x" + hypotenuse, 200, 380);
                    result =Math.cos(Math.toRadians(theta)) * hypotenuse; //SOH = 0/H

                    DecimalFormat df = new DecimalFormat("#.#");
                    String res = df.format(result);
                    System.out.println(COLORS.RED + "**********************************************************************************************");
                    System.out.println("The adjacent side value of the right angle triangle is: -> " + res);
                    System.out.println("**********************************************************************************************");
                    g.drawString(res, 400, 350);//this places the adjacent side value on the adjacent side of the right angle
                }

                // Using the TOA trigonometric ratio -> Tan theta = O/A
                else if (side_given.equals("O") && sideToBeFound.equals("A")) {
                    System.out.println(COLORS.RESET + "Enter the opposite side value");
                    double opps = number.nextDouble();
                    String opp  = Double.toString(opps);
                    System.out.println("Below is the picture of the right angle triangle");
                    g.drawString(opp, 170, 200);//this value will be placed on the opposite side
                    g.drawString(angle, 520, 300);//this angle value will be placed on the down corner of the right angle
                    g.drawString("The solution is: -> Tan " + theta + "= " + opps + "/" + sideToBeFound, 200, 380);

                    result =opps / Math.tan(Math.toRadians(theta)); //SOH = 0/H

                    DecimalFormat df = new DecimalFormat("#.#");
                    String res = df.format(result);
                    System.out.println(COLORS.RED + "**********************************************************************************************");
                    System.out.println("The adjacent side value of the right angle triangle is: -> " + res);
                    System.out.println("**********************************************************************************************");
                    g.drawString(res, 400, 350);//this places the adjacent side value on the adjacent side of the right angle
                }

                else if (side_given.equals("A") && sideToBeFound.equals("O")) { // Tan theta = O / A
                    System.out.println(COLORS.RESET + "Enter the adjacent side value");
                    double adjace = number.nextDouble();
                    String adj  = Double.toString(adjace);
                    System.out.println("Below is the picture of the right angle triangle");
                    g.drawString(adj, 400, 350);//this value will be placed on the adjacent side
                    g.drawString(angle, 520, 300);//this angle value will be placed on the down corner of the right angle
                    g.drawString("The solution is: -> Opposite side " +  "= " + "Tan theta " + "x" + adjace, 200, 380);


                    result = Math.tan(Math.toRadians(theta)) * adjace; //SOH = 0/H

                    DecimalFormat df = new DecimalFormat("#.#");
                    String res = df.format(result);
                    System.out.println(COLORS.RED + "**********************************************************************************************");
                    System.out.println("The opposite side value of the right angle triangle is: -> " + res);
                    System.out.println("**********************************************************************************************");
                    g.drawString(res, 170, 200);//this places the opposite side value on the opposite side of the right angle
                }

                else{
                    System.out.println(COLORS.RED + "You have entered incorrect options! Please restart again");
                }
            }

            else if (status.equals("second")){
                //Sin inverse trigonometric ratio
                if ((firstSide.equals("O") && secondSide.equals("H")) || (firstSide.equals("H") && secondSide.equals("O"))){
                    System.out.println(COLORS.BLACK_BOLD + "Enter the opposite side value ");
                    double opp_side = number.nextDouble();
                    String change_opp = Double.toString(opp_side);
                    System.out.println("Enter the hypotenuse side value");
                    double hypo_side = number.nextDouble();
                    String change_hypo = Double.toString(hypo_side);
                    result = Math.toDegrees(Math.asin(opp_side / hypo_side));
                    DecimalFormat df = new DecimalFormat("#.#");

                    String res = df.format(result);
                    System.out.println(COLORS.RED + "**********************************************************************************************");
                    System.out.println("The angle value of the right angle triangle is: -> " + res);
                    System.out.println("**********************************************************************************************");

                    g.drawString(change_opp, 170,200); //this is placed on the opposite side
                    g.drawString(change_hypo, 480,200); //this is placed on the hypotenuse side
                    g.drawString(res,520,300);
                    g.drawString("The solution is: -> asin theta " + "= " + change_opp + "/" + change_hypo, 200,380);
                }
                // Cosine inverse trigonometric ratio
                else if ((firstSide.equals("A") && secondSide.equals("H")) || (firstSide.equals("H") && secondSide.equals("A"))){
                    System.out.println(COLORS.BLACK_BOLD + "Enter the adjacent side value ");
                    double adjacent_side = number.nextDouble();
                    String change_adj = Double.toString(adjacent_side);
                    System.out.println("Enter the hypotenuse side value");
                    double hypo_side = number.nextDouble();
                    String change_hypo = Double.toString(hypo_side);
                    result = Math.toDegrees(Math.acos(adjacent_side / hypo_side));
                    DecimalFormat df = new DecimalFormat("#.#");

                    String res = df.format(result);
                    System.out.println(COLORS.RED + "**********************************************************************************************");
                    System.out.println("The angle value of the right angle triangle is: -> " + res);
                    System.out.println("**********************************************************************************************");

                    g.drawString(change_adj, 400,350); //this is placed on the adjacent side
                    g.drawString(change_hypo, 480,200); //this is placed on the hypotenuse side
                    g.drawString(res,520,300);
                    g.drawString("The solution is: -> acos theta " + "= " + change_adj + "/" + change_hypo, 200,380);
                }

                // Tangent inverse trigonometric ratio Tan theta = O/A
                else if ((firstSide.equals("O") && secondSide.equals("A")) || (firstSide.equals("A") && secondSide.equals("O"))){
                    System.out.println(COLORS.BLACK_BOLD + "Enter the opposite side value ");
                    double opp_side = number.nextDouble();
                    String change_opp = Double.toString(opp_side);
                    System.out.println("Enter the adjacent side value");
                    double adjacent_side = number.nextDouble();
                    String change_adj = Double.toString(adjacent_side);
                    result = Math.toDegrees(Math.atan(opp_side / adjacent_side));
                    DecimalFormat df = new DecimalFormat("#.#");

                    String res = df.format(result);
                    System.out.println(COLORS.RED + "**********************************************************************************************");
                    System.out.println("The angle value of the right angle triangle is: -> " + res);
                    System.out.println("**********************************************************************************************");

                    g.drawString(change_opp, 170,200); //this is placed on the adjacent side
                    g.drawString(change_adj, 400,350); //this is placed on the hypotenuse side
                    g.drawString(res,520,300);
                    g.drawString("The solution is: -> atan theta " + "= " + change_opp + "/" + change_adj, 200,380);
                }

                else{
                    System.out.println(COLORS.RED + "You have entered incorrect options! Please restart again");
                }
            }
            System.out.println("Wait for thirty seconds before the program proceeds to the next steps");
        }
    }

    public static void main(String[] args) throws Exception{
        System.out.println("Please enter your name");
        name = text.nextLine();
        System.out.println("Please enter the location where you would like to store the PDF document\nExample: -> C:\\Users\\m\\Downloads\\Lesson 19 Materials\\alex.pdf");
        String pdfFilePath = text.nextLine();
        OutputStream fos = new FileOutputStream(new File(pdfFilePath));

        document = new Document(PageSize.A4.rotate());
        writer = PdfWriter.getInstance(document, fos);
        document.open();
        TrigonometryCalculator t = new TrigonometryCalculator();
        System.out.println("#####################################################################");
        System.out.println(COLORS.PURPLE_BOLD_BRIGHT + "Welcome to the SOH CAH TOA calculator ");
        System.out.println("#####################################################################");
        System.out.println(COLORS.RESET + "Would you like to use the SOH CAH TOA calculator(Yes or No)?");

        user_choice = text.nextLine();
        while (user_choice.equals("Yes")){
            System.out.println(COLORS.GREEN_BOLD_BRIGHT + "#####################################################################");
            System.out.println("\t\t\t\tTrigonometry calculator Menu\nA.Calculate a side of the right angle triangle\nB.Calculate the angle of the right angle triangle\n");

            user_response = text.nextLine();
            if (user_response.equals("A")){
                status = "first";
                System.out.println(COLORS.RED + "************************************************************************");
                System.out.println("What side are you given?\nH - Hypotenuse O - Opposite A - Adjacent");
                side_given = text.nextLine();
                System.out.println(COLORS.GREEN_BOLD_BRIGHT + "************************************************************************");
                System.out.println("What side are you looking for?\nH - Hypotenuse O - Opposite A - Adjacent");
                side_given = text.nextLine();
                System.out.println(COLORS.RESET + "************************************************************************");
                System.out.println("What is the value of the angle theta(<)");

                theta = number.nextDouble();
                System.out.println("************************************************************************");
                angle = Double.toString(theta);
                j.setVisible(true);
            }

            else if (user_response.equals("B")){
                status = "second";
                System.out.println(COLORS.RED_BOLD_BRIGHT + "************************************************************************");
                System.out.println("What is the first side given?\nH - Hypotenuse O - Opposite A - Adjacent");
                firstSide = text.nextLine();
                System.out.println( "************************************************************************");

                System.out.println(COLORS.BLACK_BOLD_BRIGHT + "What is the second side given?\nH - Hypotenuse O - Opposite A - Adjacent");
                secondSide = text.nextLine();
                System.out.println( "************************************************************************");
                j.setVisible(true);
            }

            Thread.sleep(30000);
            // Taking screenshots of the results

            try {
                Robot r = new Robot();
                System.out.println(COLORS.RED_BOLD + "Enter the file path where you would like to store the image in");
                path = text.nextLine();
                System.out.println("Notification: -> Please keep the image opened for five seconds so the screenshot can be taken");
                Thread.sleep(5000);
                Dimension dimension = new Dimension(900,450);
                Rectangle capture = new Rectangle(dimension);
                BufferedImage Image = r.createScreenCapture(capture);
                ImageIO.write(Image, "png",new File(path));
                System.out.println("The image has been successfully taken!");
                System.out.println("Please enter a question number for this question");
                questionNumber = text.nextLine();

            }catch (Exception e){
                e.printStackTrace();
            }

            com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance(path);

            try {

                com.itextpdf.text.Font fontsize_18 = FontFactory.getFont(FontFactory.TIMES, 18f);
                document.add(new Paragraph("\nQuestion " + questionNumber + "\n",fontsize_18));
                document.add(img);
                document.add(new Paragraph("\n"));

            } catch (Exception e1){
                e1.printStackTrace();
            }

            System.out.println("Your question has been saved and please now wait for 30 seconds to use the calculator again");
            Thread.sleep(30000);
            j.dispose();

            System.out.println(COLORS.RESET + "Would you like to use the SOH CAH TOA calculator(Yes or No)?");
            user_choice = text.nextLine();
        }

        if (user_choice.equals("No")){
            System.out.println(COLORS.RED + "Okay,thank you!");
            document.close();
            writer.close();
        }
    }
}


