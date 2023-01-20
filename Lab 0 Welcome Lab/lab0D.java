import java.util.Objects;
import java.util.Scanner;
public class mahjong {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int zcs= input.nextInt();
        for(int cs=0; cs<zcs ; cs++){
        int count=0,san=0,er=0,count2=0,er2=0 ,er3=0,count3=0;
        String [] shoupai = new String[14];
        String s = input.next();
        int pd=0;
        String[] shoupai1 = s.split("\\D");
        String[] shoupai2 = s.split("\\d");
            String [] shoupai3 = new String[14];
        for(int i=0 ; i<15;i++){
            if(shoupai2[i].equals("b")){shoupai2[i]= String.valueOf(1);}
            if(shoupai2[i].equals("s")){shoupai2[i]= String.valueOf(2);}
            if(shoupai2[i].equals("w")){shoupai2[i]= String.valueOf(3);}
            if(shoupai2[i].equals("z")){shoupai2[i]= String.valueOf(4);}
        }
        for(int i=0; i<14; i++){
            shoupai3[i]=shoupai1[i]+shoupai2[i+1];
            //System.out.println(shoupai[i]);
            }//集合所有的手牌
        //System.out.println(" ");
            int dsaa=0;
            for(int i=1 ; i<5 ; i++){

                for(int j=1 ; j<10 ; j++){  for(int k=0;k<14;k++){
                        if(Integer.parseInt(shoupai3[k].substring(1,2))==i && Integer.parseInt(shoupai3[k].substring(0,1))==j){
                                shoupai[dsaa]=shoupai3[k];
                                dsaa++;
                                }

                }
            }}

            for(int i=0 ; i<14 ; i++){
                shoupai1[i]=shoupai[i];
                shoupai2[i]=shoupai[i];
            }



            for(int i = 0 ; i <14 ; i++) {//去除三个一样
                //System.out.println(shoupai[i].substring(0,1));
                for (int k = 1; k < 10; k++) {
                    if (Integer.parseInt(shoupai[i].substring(0, 1)) == k) {
                        int shu=0;
                        int[] del =new int[14];
                        del[0]=i;
                        for (int j = i + 1; j < 14; j++) {
                            if (shoupai[j].equals(shoupai[i])) {
                                shu++;
                                del[shu]=j;
                                //System.out.println("y");
                            }
                            if (shu == 2) {
                                for(int e=0 ; e<3 ;e++){
                                    shoupai[del[e]]= String.valueOf(0);
                                }
                            }
                        }
                    }
                }
            }


            for(int i=1; i<10 ; i++){int[]//去除小中大
                    del=new int[4];
                for(int j=0 ; j<14 ;j++){
                    if (Integer.parseInt(shoupai[j].substring(0, 1)) == i){
                        del[0]=j;
                        for(int k = j+1 ;k<14 ;k++){
                            if(!Objects.equals(shoupai[k], String.valueOf(0))
                                    &&Integer.parseInt(shoupai[k].substring(1,2))==Integer.parseInt(shoupai[j].substring(1,2))
                                    && Integer.parseInt(shoupai[k].substring(0,1))==Integer.parseInt(shoupai[j].substring(0,1))+1){
                                del[1]=k;
                                for(int l=k+1 ; l<14 ; l++){
                                    if(!Objects.equals(shoupai[l], String.valueOf(0))
                                            &&Integer.parseInt(shoupai[l].substring(1,2))==Integer.parseInt(shoupai[k].substring(1,2))
                                            && Integer.parseInt(shoupai[l].substring(0,1))==Integer.parseInt(shoupai[k].substring(0,1))+1){
                                        del[2]=l;
                                        for(int e=0;e<3;e++){
                                            shoupai[del[e]]=String.valueOf(0);

                                        }
                                        //System.out.println("ok");
                                        break;
                                    }

                                }
                                break;
                            }
                            }
                    }
                }
            }


            for(int i = 0 ; i <14 ; i++) {//去除两个一样的
                //System.out.println(shoupai[i].substring(0,1));
                for (int k = 1; k < 10; k++) {
                    if (Integer.parseInt(shoupai[i].substring(0, 1)) == k) {
                        int shu=0;
                        int[] del =new int[14];
                        del[0]=i;
                        for (int j = i + 1; j < 14; j++) {
                            if (shoupai[j].equals(shoupai[i]) && !Objects.equals(shoupai[j], String.valueOf(0))) {
                                shu++;
                                del[shu]=j;
                                //System.out.println("y");
                            }
                            if(shu==1){
                                for(int e=0 ; e<2 ;e++){
                                    shoupai[del[e]]= String.valueOf(0);
                                    er++;
                                    shu--;
                                }
                            }}}}}




        //System.out.println(san);
        /*for(int i =0 ; i<14 ; i++){
            System.out.println(shoupai[i]);
        }//已去除三个一样的*/


        //System.out.println(" ");

        /*for(int i =0 ; i<14 ; i++){
            System.out.println(shoupai[i]);
        }//两个相同已去除

         */
             //System.out.println("");

        /*for(int i =0 ; i<14 ; i++){
            System.out.println(shoupai[i]);
        }*/
        //System.out.println(er);
        for(int i=0 ; i<14 ; i++){
            if(Objects.equals(shoupai[i], String.valueOf(0)))count++;
        }



        if(er==2&&count==14){
            pd++;
        }

            for(int i=1; i<10 ; i++){//去除小中大

                for(int j=0 ; j<14 ;j++){

                    if (Integer.parseInt(shoupai1[j].substring(0, 1)) == i){
                        int[] del=new int[4];
                        del[0]=j;
                        for(int k = j+1 ;k<14 ;k++){
                            if(!Objects.equals(shoupai1[k], String.valueOf(0))
                                    &&Integer.parseInt(shoupai1[k].substring(1,2))==Integer.parseInt(shoupai1[j].substring(1,2))
                                    && Integer.parseInt(shoupai1[k].substring(0,1))==Integer.parseInt(shoupai1[j].substring(0,1))+1){
                                del[1]=k;
                                for(int l=k+1 ; l<14 ; l++){
                                    if(!Objects.equals(shoupai1[l], String.valueOf(0))
                                            &&Integer.parseInt(shoupai1[l].substring(1,2))==Integer.parseInt(shoupai1[k].substring(1,2))
                                            && Integer.parseInt(shoupai1[l].substring(0,1))==Integer.parseInt(shoupai1[k].substring(0,1))+1){
                                        del[2]=l;
                                        for(int e=0;e<3;e++){
                                            shoupai1[del[e]]=String.valueOf(0);

                                        }
                                        //System.out.println("ok");
                                        break;
                                    }

                                }
                                break;
                            }
                           }
                    }
                }
            }



            for(int i = 0 ; i <14 ; i++) {//去除三个一样
                //System.out.println(shoupai[i].substring(0,1));
                for (int k = 1; k < 10; k++) {
                    if (Integer.parseInt(shoupai1[i].substring(0, 1)) == k) {
                        int shu=0;
                        int[] del =new int[14];
                        del[0]=i;
                        for (int j = i + 1; j < 14; j++) {
                            if (shoupai1[j].equals(shoupai1[i])) {
                                shu++;
                                del[shu]=j;
                                //System.out.println("y");
                            }
                            if (shu == 2) {
                                for(int e=0 ; e<3 ;e++){
                                    shoupai1[del[e]]= String.valueOf(0);
                                }
                            }
                        }
                    }
                }
            }

            for(int i = 0 ; i <14 ; i++) {//去除两个一样的
                //System.out.println(shoupai[i].substring(0,1));
                for (int k = 1; k < 10; k++) {
                    if (Integer.parseInt(shoupai1[i].substring(0, 1)) == k) {
                        int shu=0;
                        int[] del =new int[14];
                        del[0]=i;
                        for (int j = i + 1; j < 14; j++) {
                            if (shoupai1[j].equals(shoupai1[i]) && !Objects.equals(shoupai1[j], String.valueOf(0))) {
                                shu++;
                                del[shu]=j;
                                //System.out.println("y");
                            }
                            if(shu==1){
                                for(int e=0 ; e<2 ;e++){
                                    shoupai1[del[e]]= String.valueOf(0);
                                    er2++;
                                    shu--;
                                }
                            }}}}}
            for(int i=0 ; i<14 ; i++){
                if(Objects.equals(shoupai1[i], String.valueOf(0)))count2++;
            }



            if(er2==2&&count2==14){
                pd++;
            }



            for(int i = 0 ; i <14 ; i++) {//去除三个一样
                //System.out.println(shoupai[i].substring(0,1));
                for (int k = 1; k < 10; k++) {
                    if (Integer.parseInt(shoupai2[i].substring(0, 1)) == k) {
                        int shu=0;
                        int[] del =new int[14];
                        del[0]=i;
                        for (int j = i + 1; j < 14; j++) {
                            if (shoupai2[j].equals(shoupai2[i])) {
                                shu++;
                                del[shu]=j;
                                //System.out.println("y");
                            }
                            if (shu == 2) {
                                for(int e=0 ; e<3 ;e++){
                                    shoupai2[del[e]]= String.valueOf(0);
                                }
                            }
                        }
                    }
                }
            }

            for(int i = 0 ; i <14 ; i++) {//去除两个一样的
                //System.out.println(shoupai[i].substring(0,1));
                for (int k = 1; k < 10; k++) {
                    if (Integer.parseInt(shoupai2[i].substring(0, 1)) == k) {
                        int shu=0;
                        int[] del =new int[14];
                        del[0]=i;
                        for (int j = i + 1; j < 14; j++) {
                            if (shoupai2[j].equals(shoupai2[i]) && !Objects.equals(shoupai2[j], String.valueOf(0))) {
                                shu++;
                                del[shu]=j;
                                //System.out.println("y");
                            }
                            if(shu==1){
                                for(int e=0 ; e<2 ;e++){
                                    shoupai2[del[e]]= String.valueOf(0);
                                    er3++;
                                    shu--;
                                }
                            }}}}}

            for(int i=1; i<10 ; i++){int[]//去除小中大
                    del=new int[4];
                for(int j=0 ; j<14 ;j++){
                    if (Integer.parseInt(shoupai2[j].substring(0, 1)) == i){
                        del[0]=j;
                        for(int k = j+1 ;k<14 ;k++){
                            if(!Objects.equals(shoupai2[k], String.valueOf(0))
                                    &&Integer.parseInt(shoupai2[k].substring(1,2))==Integer.parseInt(shoupai2[j].substring(1,2))
                                    && Integer.parseInt(shoupai2[k].substring(0,1))==Integer.parseInt(shoupai2[j].substring(0,1))+1){
                                del[1]=k;
                                for(int l=k+1 ; l<14 ; l++){
                                    if(!Objects.equals(shoupai2[l], String.valueOf(0))
                                            &&Integer.parseInt(shoupai2[l].substring(1,2))==Integer.parseInt(shoupai2[k].substring(1,2))
                                            && Integer.parseInt(shoupai2[l].substring(0,1))==Integer.parseInt(shoupai2[k].substring(0,1))+1){
                                        del[2]=l;
                                        for(int e=0;e<3;e++){
                                            shoupai2[del[e]]=String.valueOf(0);

                                        }
                                        //System.out.println("ok");
                                        break;
                                    }

                                }
                                break;
                            }
                           }
                    }
                }
            }

            for(int i=0 ; i<14 ; i++){
                if(Objects.equals(shoupai2[i], String.valueOf(0)))count3++;
            }

            if(er3==2&&count3==14){
                pd++;
            }


            if(pd>=1){
                System.out.println("Blessing of Heaven");
            }
            else System.out.println("Bad luck");
        }
}}
