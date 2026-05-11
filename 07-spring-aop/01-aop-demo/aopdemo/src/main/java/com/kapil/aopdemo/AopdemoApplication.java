package com.kapil.aopdemo;

import com.kapil.aopdemo.dao.AccountDAO;
import com.kapil.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		return runner -> {
			 demoOfBeforeAdvice(theAccountDAO, theMembershipDAO);
		};
	}

	private void demoOfBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		theAccountDAO.addAccount();

		theAccountDAO.setName("Kapil");
		theAccountDAO.setServiceCode("E2133");

		String name = theAccountDAO.getName();
		String serviceCode = theAccountDAO.getServiceCode();

		System.out.println("Name = "+name+" ServiceCode = "+serviceCode);

		theMembershipDAO.addAccount();

		theAccountDAO.displayInsideAccountDAO();
		theMembershipDAO.displayInsideMembershipDAO();

	}
}
