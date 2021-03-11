package com.smart_city;
import com.smart_city.controllers.*;
import com.smart_city.repositories.interfaces.*;

import java.util.Scanner;

public class Application {
    private String userLogin;
    private final UserController controller1;
    private final BuildingController controller2;
    private final CurrencyController controller3;
    private final TrainController controller4;
    private final VacancyController controller5;
    private final Scanner scanner;

    public Application(IUserRepository repo1, IBuildingRepository repo2, ICurrencyRepository repo3,
                       ITrainRepository repo4, IVacancyRepository repo5) {
        scanner =new Scanner(System.in);
        controller1 = new UserController(repo1);
        controller2 = new BuildingController(repo2);
        controller3 = new CurrencyController(repo3);
        controller4 = new TrainController(repo4);
        controller5 = new VacancyController(repo5);
    }

    public boolean start() {
        System.out.println('\n' + "Welcome. Welcome to City 17. You have chosen, or been chosen, " +
                "to relocate to one of our finest remaining urban centers.");
        while(true) {
            System.out.println("*********************************");
            System.out.println("To start using the app, select the option(1-3):");
            System.out.println("1. Sign in");
            System.out.println("2. Sign up");
            System.out.println("3. Login as a tourist");
            System.out.println("4. Exit");
            System.out.println("*********************************");
            int opt = scanner.nextInt();
            if(opt == 1) {
                if(loginUser() == true){
                    fiveModulesMenu();
                }
            } else if (opt == 2) {
                signUpUser();
            } else if (opt == 3) {
                startTourismModule();
            } else if(opt == 4) {
                return false;
            }
        }
    }

    public boolean loginUser() {
        while(true){
        System.out.println("Enter login:");
        String login = scanner.next();

        System.out.println("Enter password:");
        String password = scanner.next();

        boolean response = controller1.loginUser(login, password);
        if(response == true) {
            System.out.println("Long time no see!");
            userLogin = login;
            return true;
        } else {
            System.out.println("Wrong login or password");
            System.out.println("Go back to menu? y/n");
            Character des = scanner.next().charAt(0);
            if(des == 'y') {
                return false;
            }
        }
        }
    }

    public boolean signUpUser() {
        while(true){
            System.out.println("Enter username:");
            String username = scanner.next();
            System.out.println("Enter password:");
            String password = scanner.next();
            System.out.println("Enter your first name:");
            String firstName = scanner.next();
            System.out.println("Enter your last name:");
            String lastName = scanner.next();
            System.out.println("Education center:");
            String education = scanner.next();
            System.out.println("Job information:");
            String job = scanner.next();
            System.out.println("Business information:");
            String business = scanner.next();

            boolean response2 = controller1.isInTable(username);
            if(response2 == false){
                System.out.println("Try another username");
                continue;
            }
            boolean response =controller1.signUpUser(username, password, firstName, lastName, education, job, business);
            if(response == true) {
                System.out.println("User was created! Sign in!");
                return true;
            } else {
            System.out.println("Go back to menu? y/n");
            Character des = scanner.next().charAt(0);
            if(des == 'y') {
                return false;
                }
            }
        }
    }

    public boolean fiveModulesMenu() {
        while(true) {
            System.out.println("*********************************");
            System.out.println("Welcome to Smart City Menu!");
            System.out.println("1. Administration module(required admrights)");
            System.out.println("2. Tourism module");
            System.out.println("3. Student module");
            System.out.println("4. Jobseekers module");
            System.out.println("5. Business module");
            System.out.println("6. Logout");
            System.out.println("7. I noticed easter egg to Half-Life");
            System.out.println("*********************************");
            int opt = scanner.nextInt();
            if(opt == 1){
                if(checkAdminRights() == true){
                startAdminModule();} else {
                    System.out.println("You have no rights!");
                }
            } else if (opt == 2){
                startTourismModule();
            } else if(opt == 3){
                startStudentModule();
            } else if(opt == 4){
                startJobseekerModule();
            } else if(opt == 5){
                startBusinessModule();
            } else if(opt == 6){
                userLogin = null;
                return false;
            } else if(opt == 7){
                easterEgg();
            }
        }
    }

    public boolean startAdminModule() {
        while(true){
        System.out.println("*********************************");
        System.out.println("Welcome to Administration Module");
        System.out.println("You can maintain other 4 modules(choose option 1-5):");
        System.out.println("1. Tourism module");
        System.out.println("2. Student module");
        System.out.println("3. Jobseekers module");
        System.out.println("4. Business module");
        System.out.println("5. Work with users");
        System.out.println("6. Leave from module");
        System.out.println("*********************************");
        int opt = scanner.nextInt();
        if (opt == 1){
                startTourismModuleMaintance();
        } else if(opt == 2){
                startStudentModuleMaintance();
        } else if(opt == 3){
                startJobseekerModuleMaintance();
        } else if(opt == 4){
                startBusinessModuleMaintance();
        } else if (opt == 5) {
                startUserMaintance();
        }
        else if (opt == 6) {
            return false;
        }
        }
    }



    public boolean startTourismModule() {
        while(true){
            System.out.println('\n');
            System.out.println("*********************************");
            System.out.println("Welcome to Tourism Module");
            System.out.println("Choose option(1-5)");
            System.out.println("1. Get train schedule");
            System.out.println("2. Get way of train by id");
            System.out.println("3. Get top 5 restaurants");
            System.out.println("4. Get menu of restaurant by id");
            System.out.println("5. Go back");
            System.out.println("*********************************");
            System.out.println('\n');
            int opt = scanner.nextInt();
            if(opt == 1){
                getAllTrains();
            } else if(opt == 2){
                getTrainById();
            } else if(opt == 3){
                getTopFiveRestaurants();
            } else if(opt == 4){
                getMenuRestaurant();
            } else if(opt == 5){
                return false;
            }
        }
    }

    public boolean startStudentModule() {
        while(true){System.out.println('\n');
        System.out.println("*********************************");
        System.out.println("Welcome to Student Module");
        System.out.println("Choose option 1-6");
        System.out.println("1. List of institutes");
        System.out.println("2. List of libraries");
        System.out.println("3. List of colleges");
        System.out.println("4. List of Universities");
        System.out.println("5. Get information about education of user");
        System.out.println("6. Go back");
        System.out.println("*********************************");
        System.out.println('\n');
        int opt = scanner.nextInt();
        if(opt == 1){
            int type = 1;
            getList(type);
        } else if(opt == 2){
            int type = 2;
            getList(type);
        } else if(opt == 3){
            int type = 3;
            getList(type);
        } else if(opt == 4){
            int type = 4;
            getList(type);
        } else if(opt == 5){
            getEducationInfo(userLogin);
        } else if (opt == 6) {
            return false;
        }
        }
    }

    public boolean startJobseekerModule() {
        while(true){
            System.out.println('\n');
            System.out.println("*********************************");
            System.out.println("Welcome to Jobseeker Module");
            System.out.println("Choose option 1-5");
            System.out.println("1. List of professions");
            System.out.println("2. Find vacancies by professions' id");
            System.out.println("3. Current Job of User");
            System.out.println("4. List of Labour Centres");
            System.out.println("5. Go back");
            System.out.println("*********************************");
            System.out.println('\n');
            int opt = scanner.nextInt();
            if(opt == 1){
                getListOfProfessions();
            } else if(opt == 2){
                findVacancies();
            } else if(opt == 3){
                int type = 3;
                getJobInfo(userLogin);
            } else if(opt == 4){
                int type = 6;
                getList(type);
            }  else if (opt == 5) {
                return false;
            }
        }
    }

    public boolean startBusinessModule() {
        while(true){
            System.out.println('\n');
            System.out.println("*********************************");
            System.out.println("Welcome to Business Module");
            System.out.println("Choose option 1-5");
            System.out.println("1. Get information about business centres");
            System.out.println("2. Get information about trade centres");
            System.out.println("3. Currency information");
            System.out.println("4. Current Business of User");
            System.out.println("5. Go back");
            System.out.println("*********************************");
            System.out.println('\n');
            int opt = scanner.nextInt();
            if(opt == 1){
                int type = 7;
                getList(type);
            } else if(opt == 2){
                int type = 8;
                getList(type);
            } else if(opt == 3){
                getCurrency();
            } else if(opt == 4){
                getBusinessInfo(userLogin);
            }  else if (opt == 5) {
                return false;
            }
        }
    }

    public boolean easterEgg() {
        System.out.println('\n');
        System.out.println("*********************************");
        System.out.println("    I thought so much of City 17 that " + '\n' +
                "I elected to establish my Administration here, " + '\n' +
                "in the Citadel so thoughtfully provided by Our " + '\n' +
                "Benefactors. I have been proud to call City 17 my " + '\n' +
                "home. And so, whether you are here to stay, or passing " + '\n' +
                "through on your way to parts unknown, welcome to City 17. " + '\n' +
                "It's safer here.");
        System.out.println("*********************************");
        System.out.println('\n');
        return false;
    }




    public boolean startUserMaintance(){
        while(true) {
            System.out.println("*********************************");
            System.out.println("1. Create new user");
            System.out.println("2. Delete user");
            System.out.println("3. Give adminRights to user");
            System.out.println("4. Get list of all users");
            System.out.println("5. Back");
            System.out.println("*********************************");
            int opt = scanner.nextInt();
            if(opt == 1) {
                signUpUser();
            } else if (opt == 2){
                deleteUserByName();
            } else if(opt == 3){
                giveAdmRights();
            } else if (opt == 4){
                getAllUserList();
            } else if (opt == 5){
                return false;
            }
        }
    }

    public boolean startTourismModuleMaintance() {
        while(true) {
            System.out.println("*********************************");
            System.out.println("1. Get Train Schedule");
            System.out.println("2. Delete Train by Id");
            System.out.println("3. Add new Train to schedule");
            System.out.println("4. Get list of All Buildings");
            System.out.println("5. Delete Building by Id");
            System.out.println("6. Add new Building to the list");
            System.out.println("7. Back");
            System.out.println("*********************************");
            int opt = scanner.nextInt();
            if(opt == 1) {
                getAllTrains();
            } else if (opt == 2){
                deleteTrainById();
            } else if(opt == 3){
                createTrain();
            } else if (opt == 4){
                getAllBuildings();
            } else if (opt == 5){
                deleteBuildingById();
            } else if (opt == 6){
                createBuilding();
            } else if (opt == 7){
                return false;
            }
        }
    }

    public boolean startStudentModuleMaintance() {
        System.out.println("It will appear asap!");
        return false;
    }

    public boolean startJobseekerModuleMaintance() {
        while(true) {
            System.out.println("*********************************");
            System.out.println("1. Get all vacancies");
            System.out.println("2. Delete vacancy by Id");
            System.out.println("3. Add new vacancy");
            System.out.println("4. Back");
            System.out.println("*********************************");
            int opt = scanner.nextInt();
            if(opt == 1) {
                getAllVacancies();
            } else if (opt == 2){
                deleteVacancyById();
            } else if(opt == 3){
                createVacancy();
            } else if (opt == 4){
                return false;
            } }
    }

    public boolean startBusinessModuleMaintance() {
        while(true) {
            System.out.println("*********************************");
            System.out.println("1. Get currency table");
            System.out.println("2. Delete currency from the list by name");
            System.out.println("3. Add new currency");
            System.out.println("4. Back");
            System.out.println("*********************************");
            int opt = scanner.nextInt();
            if(opt == 1) {
                getAllCurrencies();
            } else if (opt == 2){
                deleteCurrencyByName();
            } else if(opt == 3){
                createCurrency();
            } else if (opt == 4){
                return false;
            } }
    }



    public boolean checkAdminRights(){
        boolean response = controller1.checkAdminRights(userLogin);
        return response;
    }

    public void getAllTrains(){
        System.out.println(controller4.getAllTrains());
    }

    public void getTrainById(){
        System.out.println("Enter id of train:");
        int id = scanner.nextInt();
        System.out.println(controller4.getTrain(id));
    }

    public void getTopFiveRestaurants(){
        System.out.println(controller2.getTopFiveRestaurants());
    }

    public void getMenuRestaurant(){
        System.out.println("Enter id of restaurant:");
        int id = scanner.nextInt();
        System.out.println(controller2.getMenu(id));
    }

    public void getList(int type){
        System.out.println(controller2.getList(type));
    }

    public void getEducationInfo(String userLogin){
        System.out.println(controller1.getEducationInfo(userLogin));
    }

    public void getJobInfo(String userLogin) {
        System.out.println(controller1.getJobInfo(userLogin));
    }

    public void getListOfProfessions(){
        System.out.println("*********************************");
        System.out.println("1. Office Assistant III");
        System.out.println("2. Junior Executive");
        System.out.println("3. Help Desk Operator");
        System.out.println("4. Structural Engineer");
        System.out.println("5. Programmer IV");
        System.out.println("6. Financial Analyst");
        System.out.println("7. Design Engineer");
        System.out.println("8. Senior Sales Associate");
        System.out.println("*********************************");
    }

    public boolean findVacancies() {
        while(true){
            System.out.println("Enter profession number(exit - 9):");
            int opt = scanner.nextInt();
            if (opt == 1) {
                String jobF = "Office Assistant III";
                System.out.println(controller5.findVacancies(jobF));
            } else if (opt == 2) {
                String jobF = "Junior Executive";
                System.out.println(controller5.findVacancies(jobF));
            } else if (opt == 3) {
                String jobF = "Help Desk Operator";
                System.out.println(controller5.findVacancies(jobF));
            } else if (opt == 4) {
                String jobF = "Structural Engineer";
                System.out.println(controller5.findVacancies(jobF));
            } else if (opt == 5) {
                String jobF = "Programmer IV";
                System.out.println(controller5.findVacancies(jobF));
            } else if (opt == 6) {
                String jobF = "Financial Analyst";
                System.out.println(controller5.findVacancies(jobF));
            } else if (opt == 7) {
                String jobF = "Design Engineer";
                System.out.println(controller5.findVacancies(jobF));
            } else if (opt == 8) {
                String jobF = "Senior Sales Associate";
                System.out.println(controller5.findVacancies(jobF));
            } else if(opt == 9){
                return false;
            }
        }
    }

    public void getBusinessInfo(String userLogin){
        System.out.println(controller1.getBusinessInfo(userLogin));
    }

    public void getCurrency(){
        System.out.println(controller3.getAllCurrencies());
    }

    public void deleteUserByName(){
        System.out.println("Enter username:");
        String userName = scanner.next();
        if(userName == "admin"){
            System.out.println("You can't do it");
        } else {
        System.out.println(controller1.deleteUser(userName) == true? "Something went wrong" : "Completed succesfully");}
    }

    public void giveAdmRights(){
        System.out.println("Enter username:");
        String userName = scanner.next();
        System.out.println(controller1.giveAdmRights(userName) == true? "Something went wrong" : "Completed succesfully");
    }

    public void getAllUserList(){
        System.out.println(controller1.getAllUsers());
    }

    public void deleteTrainById(){
        System.out.println("Enter id of train:");
        int trainId = scanner.nextInt();
        System.out.println(controller4.deleteTrain(trainId) == true? "Something went wrong" : "Completed succesfully");
    }

    public void createTrain(){
        System.out.println("Enter departuredPlace:");
        String dP = scanner.next();
        System.out.println("Enter arrivedPlace:");
        String aP = scanner.next();
        System.out.println("Enter departuredTime:");
        String dT = scanner.next();
        System.out.println("Enter arrivedTime:");
        String aT = scanner.next();
        System.out.println("Enter description:");
        String description = scanner.next();
        System.out.println(controller4.createTrain(dP, aP, dT, aT, description));
    }

    public void getAllBuildings(){
        System.out.println(controller2.getAllBuildings());
    }

    public void deleteBuildingById(){
        System.out.println("Enter name of building:");
        String buildingName = scanner.next();
        System.out.println(controller2.deleteBuilding(buildingName) == true? "Something went wrong" : "Completed succesfully");
    }

    public void createBuilding(){
        System.out.println("Enter name:");
        String name = scanner.next();
        System.out.println("Enter address:");
        String address = scanner.next();
        System.out.println("Enter rating:");
        double rating = scanner.nextDouble();
        System.out.println("Enter schedule:");
        String schedule = scanner.next();
        System.out.println("Enter type:");
        int type = scanner.nextInt();
        System.out.println("Enter additional info:");
        String additional= scanner.next();
        System.out.println(controller2.createBuilding(name, address, rating, schedule, type, additional));
    }

    public void getAllVacancies(){
        System.out.println(controller5.getAllVacancies());
    }

    public void deleteVacancyById(){
        System.out.println("Enter id of vacancy:");
        int vacancyId = scanner.nextInt();
        System.out.println(controller5.deleteVacancy(vacancyId) == true? "Something went wrong" : "Completed succesfully");
    }

    public void createVacancy(){
        System.out.println("Enter jobName:");
        String name = scanner.next();
        System.out.println("Enter companyName:");
        String address = scanner.next();
        System.out.println("Enter salary:");
        double salary = scanner.nextDouble();
        System.out.println("Enter address:");
        String schedule = scanner.next();
        System.out.println("Enter experience:");
        int type = scanner.nextInt();
        System.out.println("Enter additional info:");
        String additional= scanner.next();
        controller5.createVacancy(name, address, salary, schedule, type, additional);
    }

    public void getAllCurrencies(){
        System.out.println(controller3.getAllCurrencies());
    }

    public void deleteCurrencyByName(){
        System.out.println("Enter name of building:");
        String currencyName = scanner.next();
        System.out.println(controller3.deleteCurrency(currencyName) == true? "Something went wrong" : "Completed succesfully");
    }

    public void createCurrency(){
        System.out.println("Enter currency name 1:");
        String name1 = scanner.next();
        System.out.println("Enter currency 1:");
        double v1 = scanner.nextDouble();
        System.out.println("Enter salary:");
        String name2 = scanner.next();
        System.out.println("Enter address:");
        double v2 = scanner.nextDouble();
        System.out.println("Enter coefficient:");
        double coef = scanner.nextDouble();
        controller3.createCurrency(name1, v1, name2, v2, coef);
    }

}
