package com.example.taco_c;

public class burritoResturant {
        private String resturantName;
        private String resturantURL;

        private void setBurritoInfo(Integer coffeeCrowd){
            switch (coffeeCrowd){
                case 0: //illegal petes
                    resturantName="Illegal Petes on The Hill";
                    resturantURL="https://www.illegalpetes.com/location/illegal-petes-boulder-the-hill/";
                    break;
                case 1: //
                    resturantName="Chipotle on 29th Street";
                    resturantURL="https://locations.chipotle.com/co/boulder/1650-28th-st";
                    break;
                case 2: //Mars
                    resturantName="Bartaco on Pearl Street";
                    resturantURL="https://bartaco.com/";
                    break;
                default:
                    resturantName="none";
                    resturantURL="https://www.google.com/search?q=sushi+in+boulder&npsic=0&rflfq=1&rlha=0&rllag=40011859,-105270371,699&tbm=lcl&ved=2ahUKEwir7qCB2r3mAhVIbs0KHXk-BVkQtgN6BAgLEAQ&tbs=lrf:!1m5!1u5!3m2!5m1!1sgcid_3sushi_1restaurant!4e2!1m5!1u8!2m3!8m2!1u805!3e1!1m4!1u17!2m2!17m1!1e2!1m4!1u3!2m2!3m1!1e1!1m4!1u2!2m2!2m1!1e1!1m4!1u1!2m2!1m1!1e1!1m4!1u1!2m2!1m1!1e2!1m4!1u15!2m2!15m1!1saccepts_1reservations!1m4!1u15!2m2!15m1!1swelcomes_1children!1m4!1u15!2m2!15m1!1sserves_1beer!1m4!1u15!2m2!15m1!1sfeels_1romantic!1m4!1u15!2m2!15m1!1shas_1delivery!1m4!1u15!2m2!15m1!1sserves_1wine!1m4!1u22!2m2!21m1!1e1!1m5!1u15!2m2!15m1!1shas_1takeout!4e2!1m5!1u15!2m2!15m1!1shas_1wheelchair_1accessible_1entrance!4e2!1m5!1u15!2m2!15m1!1sserves_1vegetarian!4e2!1m5!1u15!2m2!15m1!1shas_1seating_1outdoors!4e2!1m5!1u15!2m2!15m1!1spopular_1with_1tourists!4e2!1m5!1u15!2m2!15m1!1sserves_1lunch!4e2!1m5!1u15!2m2!15m1!1shas_1childrens_1menu!4e2!1m5!1u15!2m2!15m1!1sserves_1dinner!4e2!2m4!1e17!4m2!17m1!1e2!2m1!1e2!2m1!1e5!2m1!1e1!2m1!1e3!3sCgIIASABKgJVUw,lf:1,lf_ui:9&rldoc=1#rlfi=hd:;si:;mv:[[40.1083734,-105.11392839999999],[39.971804299999995,-105.29211810000001]];tbs:lrf:!1m5!1u5!3m2!5m1!1sgcid_3sushi_1restaurant!4e2!1m4!1u17!2m2!17m1!1e2!1m4!1u3!2m2!3m1!1e1!1m4!1u2!2m2!2m1!1e1!1m4!1u1!2m2!1m1!1e1!1m4!1u1!2m2!1m1!1e2!1m4!1u22!2m2!21m1!1e1!2m1!1e2!2m1!1e5!2m1!1e1!2m1!1e3!2m4!1e17!4m2!17m1!1e2!3sCgIIASABKgJVUw,lf:1,lf_ui:9";
            }
        }

        public String getResturantName(){
            return resturantName;
        }

        public String getResturantURL(){
            return resturantURL;
        }

        public void setResturantName(Integer location){
            setBurritoInfo(location);
        }

        public void setResturantURL(Integer loctaion){
            setBurritoInfo(loctaion);
        }

    }

