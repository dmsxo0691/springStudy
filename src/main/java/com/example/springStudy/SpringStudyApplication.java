package com.example.springStudy;

import com.example.springStudy.chap05.config.AppCtx;
import com.example.springStudy.chap05.spring.DuplicateMemberException;
import com.example.springStudy.chap05.spring.MemberNotFoundException;
import com.example.springStudy.chap05.spring.RegisterRequest;
import com.example.springStudy.chap05.spring.WrongIdPasswordException;
import com.example.springStudy.chap05.spring.ChangePasswordService;
import com.example.springStudy.chap05.spring.MemberRegisterService;
import com.example.springStudy.chap05.spring.MemberInfoPrinter;
import com.example.springStudy.chap05.spring.MemberListPrinter;
import com.example.springStudy.chap05.spring.VersionPrinter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@SpringBootApplication
public class SpringStudyApplication {

    private static ApplicationContext ctx = null;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SpringStudyApplication.class, args);

        ctx =  new AnnotationConfigApplicationContext(AppCtx.class);

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("명령어 입력");
            String command = reader.readLine();
            if (command.equalsIgnoreCase("exit")) {
                System.out.println("종료");
                break;
            }
            if (command.startsWith("new ")) {
                processNewCommand(command.split(" "));
                continue;
            } else if (command.startsWith("change ")) {
                processChangeCommand(command.split(" "));
                continue;
            } else if (command.equals("list")) {
                processListCommand();
                continue;
            } else if (command.startsWith("info")) {
                processInfoCommand(command.split(" "));
                continue;
            } else if (command.equals("version")) {
                processVersionCommand();
                continue;
            }
            printHelp();
        }
    }

    private static void processNewCommand(String[] arg) {
        if (arg.length != 5) {
            printHelp();
            return;
        }

        MemberRegisterService memberRegisterService =
                ctx.getBean(MemberRegisterService.class);
        RegisterRequest req = new RegisterRequest();
        req.setEmail(arg[1]);
        req.setName(arg[2]);
        req.setPassword(arg[3]);
        req.setConfirmPassword(arg[4]);

        if (!req.isPasswordEqualToConfirmPassword()) {
            System.out.println("암호가 일치하지 않습니다");
            return;
        }
        try {
            memberRegisterService.regist(req);
            System.out.println("등록");
        } catch (DuplicateMemberException e) {
            System.out.println("이미 존재하는 이메일");
        }
    }

    private static void processChangeCommand(String[] arg) {
        if (arg.length != 4) {
            printHelp();
            return;
        }
        ChangePasswordService changePasswordService =
                ctx.getBean(ChangePasswordService.class);
        try {
            changePasswordService.changePassword(arg[1], arg[2], arg[3]);
            System.out.println("암호 변경 완료");
        } catch (MemberNotFoundException e) {
            System.out.println("존재하지 않는 이메일");
        } catch (WrongIdPasswordException e) {
            System.out.println("이메일과 암호가 일치하지 않음");
        }
    }

    private static void processListCommand() {
        MemberListPrinter listPrinter =
                ctx.getBean("listPrinter", MemberListPrinter.class);
        listPrinter.printAll();
    }

    private static void printHelp() {
        System.out.println();
        System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요");
        System.out.println("명령어 사용법");
        System.out.println("new 이메일 이름 암호 암호확인");
        System.out.println("change 이메일 현재비번 변경비번");
        System.out.println();
    }

    private static void processInfoCommand(String[] arg){
        if(arg.length != 2){
            printHelp();
            return;
        }
        MemberInfoPrinter memberInfoPrinter =
                ctx.getBean("infoPrinter", MemberInfoPrinter.class);
        memberInfoPrinter.printMemberInfo(arg[1]);
    }

    private static void processVersionCommand(){
        VersionPrinter versionPrinter =
                ctx.getBean("versionPrinter", VersionPrinter.class);
        versionPrinter.print();
    }
}


