package com.file_hiding_system;

import com.file_hiding_system.dao.UserDAO;
import com.file_hiding_system.service.EncryptionService;
import com.file_hiding_system.service.OTPService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

//@SpringBootApplication
public class FileHidingSystem1Application {

	public static void main(String[] args) {
		SpringApplication.run(FileHidingSystem1Application.class, args);

		Scanner scanner = new Scanner(System.in);
		UserDAO userDAO = new UserDAO();

		System.out.print(" Enter Email : ");
		String email = scanner.nextLine();

		String otp = OTPService.generateOPT();
		OTPService.sendEmail(email, otp);

		System.out.print(" Enter OTP : ");
		String enteredOtp = scanner.nextLine();

		if (otp.equals(enteredOtp)) {
			System.out.println(" Login successful !");

			System.out.print(" Enter file content to encrypt : ");
			String content = scanner.nextLine();

			try {
				String encrypted = EncryptionService.encrypt(content);
				System.out.println(" Encrypted Data : " + encrypted);

				String decrypted = EncryptionService.decrypt(encrypted);
				System.out.println(" Decrypted Data : " + decrypted);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

		else {
			System.out.println(" Invalid OPT !");
		}
		scanner.close();
	}
}
