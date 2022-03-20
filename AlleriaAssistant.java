/* ***************************************
  @author    Alireza Rahimi
  @date      11 December 2021
  @version   7
     
       (mini Project level 7)
   
   This program is a chatbot intended to be a personal assistant talking to the user about a specific topic 
   which is computer games.
   
   Overall, it asks personal and general questions about this topic several times 
   and uses its records to respond them in a limited way. Then sorts the user interest 
   based on how many times they answered each topic. Possible human error handled.
   
*************************************** */

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

class AlleriaAssistant
{
    public static void main (String [] a)
    {
        // levels 1 to 3 inclusive
        introduce(); 
        askName(); 
        tellAskInterest(); 
        userStatus();
        
        // levels 4 to 7 inclusive
        final String sortedAnswer = repeatedQuestions(); 
        System.out.println(sortedAnswer);
        Delay(3500);

        goodBye(); 
        
        System.exit(0);
    }
    
    
    // Shows the entered string (argument) as a message and gets user response from keyboard and returns it as a string.
    public static String inputString(String message)
    {
           Scanner scanner = new Scanner(System.in);

           System.out.println(message);
           String response = scanner.nextLine();

           return response;
    }
    
    
    
    // Return a random int between 0 (inclusive) and bound (exclusive)
    public static int randomInt(int bound) 
    {
    Random r = new Random(); // built-in type
    return r.nextInt(bound); // built-in method
    }
    
    
    // Pause the program for x milliseconds
    public static void Delay(int ms) 
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        
        return;
    }
    
    
    // after random hello phrase printed, introduces itself and its developer.
    public static void introduce()
    {
        final String[] hello = {"Hello!","Greetings!","Hi!","Hola!"};
        final int size = hello.length;
        String message = hello[randomInt(size)];
        System.out.println(message);

        Delay(700);

        message = "My name is Alleria. I am a personal Assistant developed by Alireza.";
        System.out.println(message);

        Delay(1200);

        return;
    }
    
    
    
    // asks user for their name and includes it in a nice to meet you phrase and prints it.
    public static void askName()
    {
        final String userName = inputString("Please enter your name so I have something to remember you with.");

        Delay(700);

        String message = "Glad to know you " + userName + "." + " You have such a nice name!";
        System.out.println(message);

        Delay(700);

        return;
    }
    
    
    
    // ask user their opinion about games and return the response
    public static String getUserInterest()
    {
        String question = "What artificially intelligent game do you find most thrilling?";
        final String userResponse = inputString(question);
        
        Delay(100);
        
        return userResponse;
    }
    
    
    
    // print cahtbot's interest and call another method to know user interest. Then use the result to generate and print a sentence.
    public static void tellAskInterest()
    {
        final String interest = "Computer Games";
        final String myInterest = "I am designed to be interested in " + interest + ". Specially in the ones with complicated AIs!";
        System.out.println(myInterest);

        Delay(3000);

        final String userInterest = getUserInterest();

        System.out.println(userInterest + "? I love it! I think it's one of the bests.");

        Delay(1500);

        return;
    }
    
    
    
    // based on input argument, do something.
    //if argument is 'Y' ask user something and print another string. else print a particular string.
    public static void commentOnUserStatus(String YorN)
    {
        final String yesMessage = "Oh nice! How long have you played it?";
        final String goodWish = "Awesome! Good luck with it.";
        final String noMessage = "Oh you have no idea what you have missed! I strongly recommend you to play it.";

        if (YorN.equalsIgnoreCase("Y"))
        {
            final String howLong = inputString(yesMessage);
            Delay(100);
            System.out.println(goodWish);
        }
        else 
        {
            System.out.println(noMessage);
        }

        Delay(600);
        return;
    }
    
    
    
    // this method asks about user playing status and uses user response as the argument to call another method.
    // Possible error handling applied using a while loop.
    public static void userStatus()
    {
        final String question = "Do you personally play this game? (Y/N)";
        final String possibleError = "I could not recognize your answer. Please answer again using Y or N:";

        boolean looping = true;

        while(looping)
        {
            String playedOrNot = inputString(question);
            Delay(100);
            if ( playedOrNot.equalsIgnoreCase("Y") || playedOrNot.equalsIgnoreCase("N") )
            {
                commentOnUserStatus(playedOrNot);

                looping = false;
            }
            else
            {
                System.out.println(possibleError);
            }
        }

        return;
    }
    
    
    // prints the reason it has to go and prints a random goodbye phrase.
    public static void goodBye()
    {
        String message = "I just detected overheating on one of my CPUs! Unfortunately, I have to shutdown my systems to avoid possible damage. Sorry for any inconvenience that may cause.";
        System.out.println(message);
        
        Delay(2000);
        
        final String[] goodbye = {"See you later!","Have a nice day!","Bye!","Bye bye!","Catch you later!"};
        final int size = goodbye.length;
        message = goodbye[randomInt(size)];
        System.out.println(message);
        
        return;
    }
    
    
    // gets record variable name and triggers array and assigns triggers array to the record field called trigs. Then return the record variable.
    public static MyDatabase setTrigs(MyDatabase MyData, String[] Trigs)
    {
        MyData.trigs = Trigs;

        return MyData;
    }
    
    
    // gets record variable name and responses array and assigns triggers array to the record field called responses. Then return the record variable.
    public static MyDatabase setResponses(MyDatabase MyData, String[] Responses)
    {
        MyData.responses = Responses;

        return MyData;
    }
    
    
    // gets record variable name and an integer and assigns the integer to the record field called popularity. Then return the record variable.
    public static MyDatabase setPopularity(MyDatabase MyData,int amount)
    {
        MyData.popularity = amount;

        return MyData;
    }
    
    
    // create and initiate a new record variable and return it taking 2 string array arguments for trigs and responses. 
    // for record type MyDatabase
    public static MyDatabase createTrigNresponse(String[] Trigs, String[] Responses)
    {
        MyDatabase trigNresponse = new MyDatabase();

        trigNresponse = setTrigs(trigNresponse, Trigs);
        trigNresponse = setResponses(trigNresponse, Responses);
        trigNresponse = setPopularity(trigNresponse, 0);

        return trigNresponse;
    }
    
    public static MyDatabase CreateGenreTrigs()
    {

        final String trig0 = "Shooter";
        final String trig1 = "MOBA";
        final String trig2 = "Survival";
        final String trig3 = "Strategy";

        final String response0 = "Shooter or Shooting! They come in firs person and third person. You have oppurtunity to fight with enemies with a variety of guns!";
        final String response1 = "MOBA stands for Multiplayer Online Battle Arena. The name determines everything!";
        final String response2 = "You need to roam in the world and look for goods, then survive yourself using them!";
        final String response3 = "A strategy game or strategic game is a game in which the players' uncoerced, and often autonomous, decision-making skills have a high significance in determining the outcome. Almost all strategy games require internal decision tree-style thinking, and typically very high situational awareness.";    

        final String[] MyTrigs = {trig0,trig1,trig2,trig3};
        final String[] MyResponses = {response0,response1,response2,response3}; 

        MyDatabase trigNresponse = createTrigNresponse(MyTrigs,MyResponses);

        return trigNresponse;

    }
    
    
    public static MyDatabase CreatePlatformTrigs()
    {

        final String trig0 = "PC";
        final String trig1 = "Console";
        final String trig2 = "Mobile";


        final String response0 = "Best gaming option, because you can build your own PC, you have more control over what games you play and how the system operates than you would with a console.";
        final String response1 = "Consoles have advantages over PCs: They are easy to use, don't require upgrades, make for simple multiplayer with console-owning friends, are generally cheaper, and use wireless controllers that allow you to have a more active experience.";
        final String response2 = "Some multiplayer mobile games help children to develop qualities such as collaboration and cooperation. It can improve their social connections, develop bonds, trust and teach them to play with morals that can stay with them forever.";


        final String[] MyTrigs = {trig0,trig1,trig2};
        final String[] MyResponses = {response0,response1,response2}; 

        MyDatabase trigNresponse = createTrigNresponse(MyTrigs,MyResponses);

        return trigNresponse;

    }
    
    
    public static MyDatabase CreateCompanyTrigs()
    {

        final String trig0 = "Ubisoft";
        final String trig1 = "Valve";
        final String trig2 = "Rockstar";
        final String trig3 = "Activision";

        final String response0 = "Ubisoft is a nice one, Everything they make has some satisfying gameplay, a decent story and mechanics that work pretty well.";
        final String response1 = "Valve is my developer's favourite, because they deliver high-quality games that have great stories, excellent characters, and are typically ranked among the best games ever made.";
        final String response2 = "Rockstar Games is a video game publisher established under Take-Two Interactive in 1998. It is best known for the Grand Theft Auto series.";
        final String response3 = "Activision is a leading worldwide developer, publisher, and distributor of interactive entertainment for various gaming consoles, handheld platforms, and PC.";   

        final String[] MyTrigs = {trig0,trig1,trig2,trig3};
        final String[] MyResponses = {response0,response1,response2,response3}; 

        MyDatabase trigNresponse = createTrigNresponse(MyTrigs,MyResponses);

        return trigNresponse;

    }
    
    
    public static MyDatabase CreatecontrollerTrigs()
    {

        final String trig0 = "Keyboard";
        final String trig1 = "Joystick";
        final String trig2 = "Touchscreen";
        final String trig3 = "eyetracking";

        final String response0 = "Wow keyboard! That is my developer's favourite :D";
        final String response1 = "Joystick is a classic one!";
        final String response2 = "It is difficult to have full control using touchscreen in games. Good Job!";
        final String response3 = "Unfortunately eyetracking technology has not spread too much. Good news is, it is developing rapidly!";    

        final String[] MyTrigs = {trig0,trig1,trig2,trig3};
        final String[] MyResponses = {response0,response1,response2,response3}; 

        MyDatabase trigNresponse = createTrigNresponse(MyTrigs,MyResponses);

        return trigNresponse;
    }
    
    
    // get a record variable name and return the value of its 'trigs' field
    public static String[] getTrigs(MyDatabase MyData)
    {
        String[] Trigs = MyData.trigs;

        return Trigs;
    }
    
    
    // get a record variable name and return the value of its 'responses' field
    public static String[] getResponses(MyDatabase MyData)
    {
        String[] Responses = MyData.responses;

        return Responses;
    }
    
    
    // get record variable name, increase 1 to its 'popularity' field, then return the record variable.
    public static MyDatabase increase1popularity(MyDatabase MyData)
    {

        MyData.popularity = MyData.popularity + 1;


        return MyData;
    }
    
    
    // get a record variable name and return the value of its 'popularity' field
    public static int getPopularity(MyDatabase MyData)
    {
        int Popularity = MyData.popularity;

        return Popularity;
    }
    
    

    // Gets triggers array, responses array, and user response as argument. Check Triggers and print corresponding responses.
    // Exception responses handled. 
    public static void ChckTrigNRespond(String[] Trigs, String[] Responses, String userResponse)
    {
        int arraySize = Trigs.length;

        for (int index = 0 ; index < arraySize ; index++)
        {
            if ( userResponse.equalsIgnoreCase(Trigs[index]) )
                {
                    System.out.println(Responses[index]);
                    Delay(3400);
                    return;
                }
            else
                {
                    ;
                }
        }
        Delay(200);
        System.out.println("I havo no information about that in my databases. Please try again picking something from the list.");
        Delay(1000);
        return;
    }
    
    // Extract trigs and responses from given record variable
    // choose a topic to ask a random question about
    // pass the extracted arrays and user response to the asked question to another method
    // another method prints appropriate answer based on its arguments
    public static void RandomQuestion(MyDatabase MyData, String userResponse)
    {
        String[] Trigs = getTrigs(MyData);
        String[] Responses = getResponses(MyData);
        String response = "";

        final String[] genreQuestions = {"Which one of following computer game generes do you want to know about? (Shooter , MOBA, Survival, Strategy)", "Please pick your interest to discuss it. (Shooter , MOBA, Survival, Strategy)"};
        final String[] platformQuestions = {"Please pick one of the following gaming platforms to talk about. (PC, Console, Mobile)" , "Which of the following gaming platforms would you talk about? (PC, Console, Mobile)"};
        final String[] companyQuestions = {"Which company are you curious to know about? (Ubisoft, Valve, Rockstar, Activision)","Do you wish to know about one of the following gaming companies? Just State it! (Ubisoft, Valve, Rockstar, Activision)"};
        final String[] controllerQuestions = {"Which of the following controller types are you most comfortable with? (Keyboard, Joystick, touchscreen, eyetracking)","Please pick one of the following to talk about. (Keyboard, Joystick, touchscreen, eyetracking)"}; 

        switch (userResponse)
        {
            case "genre":
                response = inputString( genreQuestions[randomInt(2)] );
                Delay(100);
                ChckTrigNRespond(Trigs, Responses, response);
                break;

            case "platform":
                response = inputString( platformQuestions[randomInt(2)] );
                Delay(100);
                ChckTrigNRespond(Trigs, Responses, response);
                break;

            case "company":
                response = inputString( companyQuestions[randomInt(2)] );
                Delay(100);
                ChckTrigNRespond(Trigs, Responses, response);
                break;

            case "controller":
                response = inputString( controllerQuestions[randomInt(2)] );
                Delay(100);
                ChckTrigNRespond(Trigs, Responses, response);
                break;  
        }
    }

    
    
    // extract popularity field of 4 record variables of type MyDatabase and assign them to a integer array and return it.
    public static int[] getPopularityDetails(MyDatabase genre, MyDatabase platform, MyDatabase company, MyDatabase controller)
    {
        final int Genre = getPopularity(genre);
        final int Platform = getPopularity(platform);
        final int Company = getPopularity(company);
        final int Controller = getPopularity(controller);

        final int[] AllPopularities = {Genre, Platform, Company, Controller};

        return AllPopularities;
    }
    
    
    // take an integer array and a string array. 
    // sort the integer array ascending.
    // manipulate String array in which way corresponding to the integer array values.
    public static void BubbleSort(int[] array, String[] array1) 
    {
        int size = array.length;
        int temp = 0;
        String temp1 = "";
        for (int pass = 0 ; pass < size ; pass++) 
        {
            for (int position = 1 ; position < (size - pass) ; position++) 
            {
                if (array[position - 1] > array[position]) 
                {
                    // swapping using temporary values (integer array)
                    temp = array[position - 1];
                    array[position - 1] = array[position];
                    array[position] = temp;
                    // // swapping using temporary values (string array)
                    temp1 = array1[position - 1];
                    array1[position - 1] = array1[position];
                    array1[position] = temp1;
                }
            }
        }
    }
    
    
    // create 4 records for topics
    // ask questions and repond to answers by calling other methods (skip|stop) to skip question asking.
    // get popularity of each record variable. 
    // sort ascending but store in a string, descending popular topic names by sorting the popularity array and manipulating correspondence.
    // return the final string
    public static String repeatedQuestions()
    {
        MyDatabase GenreTrigNResponse = CreateGenreTrigs();
        MyDatabase PlatformTrigNResponse = CreatePlatformTrigs();
        MyDatabase CompanyTrigNResponse = CreateCompanyTrigs();
        MyDatabase controllerTrigNResponse = CreatecontrollerTrigs();

        String case1 = "genre";
        String case2 ="platform";
        String case3 = "company";
        String case4 = "controller";

        final String Question = "\nPlease choose one of following topics about gaming to discuss by entering its number.(enter 'skip' to skip these discussions)\n1) Game Geners\n2) Gaming Platforms\n3) Gaming Companies\n4) Gaming Controllers";
        final String ExceptionMessage = "I could not recognize your response. Please try again entering numbers 1 to 4 or 'stop' to skip question asking.";

        String userResponse = inputString(Question);

        while(!userResponse.equalsIgnoreCase("stop") && !userResponse.equalsIgnoreCase("skip"))
        {
            switch (userResponse)
            {
                case "1":
                   GenreTrigNResponse = increase1popularity(GenreTrigNResponse);
                   RandomQuestion(GenreTrigNResponse, case1); 
                   break;

                case "2":
                    PlatformTrigNResponse = increase1popularity(PlatformTrigNResponse);
                    RandomQuestion(PlatformTrigNResponse, case2);
                    break;

                case "3": 
                    CompanyTrigNResponse = increase1popularity(CompanyTrigNResponse);
                    RandomQuestion(CompanyTrigNResponse, case3);
                    break;

                case "4": 
                    controllerTrigNResponse = increase1popularity(controllerTrigNResponse);
                    RandomQuestion(controllerTrigNResponse, case4);
                    break;

                default:
                    System.out.println(ExceptionMessage);
            }
            Delay(200);
            userResponse = inputString(Question);
        }

        final int[] popularitydetails = getPopularityDetails(GenreTrigNResponse, PlatformTrigNResponse, CompanyTrigNResponse, controllerTrigNResponse); 
        final String[] PopularityNames = {"Genre", "Platform", "Company", "Controller"};
        BubbleSort(popularitydetails,PopularityNames);

        final String[] SortedOrder = PopularityNames;
        final String finalAnswer = "\nThe following list shows your interest rank in each topic about computer gaming:\n1) " + SortedOrder[3] + " --------------------------- " + popularitydetails[3] +" Time(s)\n2) " + SortedOrder[2] + " --------------------------- " + popularitydetails[2] +" Time(s)\n3) " + SortedOrder[1] + " --------------------------- " + popularitydetails[1] + " Time(s)\n4) " + SortedOrder[0] + " --------------------------- " + popularitydetails[0] + " Time(s)\n";
        return finalAnswer;
    }
    
}



// create new record (user-defined type) called MyDatabase and define its fields.
class MyDatabase
{
    String[] trigs;
    String[] responses;
    int popularity;
}