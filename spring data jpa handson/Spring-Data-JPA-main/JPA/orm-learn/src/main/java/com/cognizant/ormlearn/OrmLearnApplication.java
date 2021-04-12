package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {
	private final static Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	// private static CountryService countryService;

	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;

	public static void main(String[] args) throws CountryNotFoundException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		// countryService = context.getBean(CountryService.class);
		// Country country = context.getBean(Country.class);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);
		LOGGER.info("Inside main");
		// testGetAllCountries();
		// getAllCountriesTest();
		// testAddCountry(country);
		// testUpdateCountry();
		// testDeleteCountry();
		// testSearchByPlaceHolder();
		// testNameStartWith();
		// testSortCountry();
		// testGetAllCountries();

		// testAddEmployee();
		// testGetEmployee();
		// testUpdateEmployee();
		// testGetDepartment();
		// testAddSkillToEmployee();
		// testGetSkills();
		// testGetAllPermanentEmployees();
		// testGetAverageSalary();
		// testGetAllEmployees();

	}

	/*
	 * private static void testGetAllCountries() {
	 * 
	 * LOGGER.info("Start"); List<Country> countries =
	 * countryService.getAllCountries(); LOGGER.debug("countries={}", countries);
	 * LOGGER.info("End");
	 * 
	 * }
	 * 
	 * private static void getAllCountriesTest() throws CountryNotFoundException {
	 * 
	 * LOGGER.info("Start"); Country country =
	 * countryService.findCountryByCode("IN"); LOGGER.debug("Country:{}", country);
	 * LOGGER.info("End");
	 * 
	 * }
	 * 
	 * private static void testAddCountry(Country country) { LOGGER.info("Start");
	 * country.setCode("LK"); country.setName("SriLanka");
	 * countryService.addCountry(country); LOGGER.info("end"); }
	 * 
	 * private static void testUpdateCountry() { LOGGER.info("Start");
	 * countryService.updateCountry("LK", "Sri Lanka"); LOGGER.info("end"); }
	 * 
	 * private static void testDeleteCountry() { LOGGER.info("Start");
	 * countryService.deleteCountry("LK"); LOGGER.info("end"); }
	 * 
	 * private static void testSearchByPlaceHolder() {
	 * 
	 * LOGGER.info("start"); List<Country> countries =
	 * countryService.searchByPlaceHolder("di"); LOGGER.debug("countries={}",
	 * countries); LOGGER.info("end"); }
	 * 
	 * private static void testNameStartWith() { LOGGER.info("start"); List<Country>
	 * countries = countryService.searchByStartingLetter("I");
	 * LOGGER.debug("countries={}", countries); LOGGER.info("end"); }
	 * 
	 * private static void testSortCountry() { LOGGER.info("start"); List<Country>
	 * countries = countryService.searchByStartingLetter("Ind");
	 * LOGGER.debug("countries={}", countries); LOGGER.info("end"); }
	 */

	private static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.info("End");
	}

	private static void testAddEmployee() {
		LOGGER.info("testAddEmployee start...");
		Employee employee = new Employee("Debayan", 26175.00, true, parseDate("1998-06-29"));
		Department department = new Department("PAT");
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.info("end...");
	}

	private static void testUpdateEmployee() {
		LOGGER.info("start");
		int employeeId = 1;
		Employee employee = employeeService.get(employeeId);
		employee.setDepartment(new Department("GENC"));
		employeeService.save(employee);
		LOGGER.debug("Employee={}", employee);
		LOGGER.debug("Department={}", employee.getDepartment());
		LOGGER.info("end");
	}

	private static void testGetDepartment() {
		LOGGER.info("start");
		int departmentId = 4;
		Department department = departmentService.get(departmentId);
		LOGGER.debug("Department={}", department);
		LOGGER.debug("Employee={}", department.getEmployeeList());
		LOGGER.info("end");
	}

	private static void testAddSkillToEmployee() {
		LOGGER.info("start");
		int employeeId = 1;
		Employee employee = employeeService.get(employeeId);
		Set<Skill> skills = new HashSet<>();
		Skill skill = new Skill("JAVA");
		Skill skill2 = new Skill("MySQL");
		skills.add(skill);
		skills.add(skill2);
		skillService.save(skill);
		skillService.save(skill2);
		employee.setSkillList(skills);
		employeeService.save(employee);
		LOGGER.info("end");
	}

	private static void testGetSkills() {
		LOGGER.info("start");
		int employeeId = 1;
		Employee employee = employeeService.get(employeeId);
		LOGGER.debug("Skills={}", employee.getSkillList());
		LOGGER.info("end");
	}

	public static void testGetAllPermanentEmployees() {
		LOGGER.info("Start");
		List<Employee> employees = employeeService.getAllPermanentEmployees();
		LOGGER.debug("Permanent Employees:{}", employees);
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
		LOGGER.info("End");
	}

	public static void testGetAverageSalary() {
		LOGGER.info("Start");
		int deptId = 4;
		double avgSalary = employeeService.getAverageSalary(deptId);
		LOGGER.debug("Average Salary", avgSalary);
		LOGGER.info("End");
	}

	public static void testGetAllEmployees() {
		LOGGER.info("Start");
		List<Employee> employees = employeeService.getAllEmployeesNative();
		LOGGER.debug("Employees:{}", employees);
		LOGGER.info("End");
	}

}
