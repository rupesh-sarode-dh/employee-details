package org.employeeData.route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.sql.SqlComponent;
import org.apache.camel.model.rest.RestBindingMode;
import org.employeeData.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub

		restConfiguration().bindingMode(RestBindingMode.json);

		rest("/api").get("/employees").to("direct:getEmployees");

		from("direct:getEmployees")
				.setBody(simple("Hello Rupesh and Sarath"));

		// from("direct:getEmployees").to("sql-stored:GET_EMPLOYEES()?dataSource=#dataSource").process(new
		// Processor() {
		// public void process(Exchange xchg) throws Exception {
		// System.out.println("We are Here !!! ");
		// System.out.println("We are Here !!! ");
		// System.out.println("We are Here !!! ");
		// System.out.println("xchg.getIn().getBody() : - " + xchg.getIn().getBody());
		// System.out.println("xchg.getIn().getBody() : - " +
		// xchg.getIn().getBody().getClass().arrayType());
		// LinkedHashMap<String, ArrayList<Map<String, String>>> dataList =
		// (LinkedHashMap<String, ArrayList<Map<String, String>>>) xchg
		// .getIn().getBody();
		// List<Employee> employees = new ArrayList<Employee>();
		// System.out.println("dataList: - " + dataList);
		// System.out.println("dataList: - " + dataList);

		// for (Map<String, String> data : dataList.get("#result-set-1")) {
		// System.out.println("data : - " + data);
		// Employee employee = new Employee();
		// employee.setEmpId(data.get("emp_id"));
		// employee.setFirstName(data.get("first_name"));
		// employee.setLastName(data.get("last_name"));
		// employee.setContactNo(data.get("contact"));
		// System.out.println("employee: - " + employee);
		// employees.add(employee);
		// System.out.println("employees: - " + employees);
		// }
		// LinkedHashMap<String, List<Employee>> hashMap = new LinkedHashMap<String,
		// List<Employee>>();
		// hashMap.put("GetEmployeeDetails", employees);
		// xchg.getIn().setBody(hashMap);
		// }
		// });

		// rest("/api").post("/addEmployee").to("direct:addEmployee");

		// // from("direct:addEmployee").log("Headers: - " + "${headers}").log("Headers:
		// - " + "${body}")
		// // .log("body1: - " + "${body['createEmployee']}").log("body2: - " +
		// "${body['createEmployee']['empId']}")
		// // .to("sql-stored:ADD_EMPLOYEE(VARCHAR 'empId'
		// ${body['createEmployee']['empId']}, "
		// // + "VARCHAR 'firstName' ${body['createEmployee']['firstName']}, "
		// // + "VARCHAR 'lastName' ${body['createEmployee']['lastName']}, "
		// // + "VARCHAR 'contactNo'
		// ${body['createEmployee']['contactNo']})?dataSource=#dataSource");
		// from("direct:addEmployee").log("Headers: - " + "${headers}").log("Headers: -
		// " + "${body}")
		// .log("body1: - " + "${body['createEmployee']}").log("body2: - " +
		// "${body['createEmployee']['empId']}")
		// .to("sql-stored:ADD_EMPLOYEE(VARCHAR 'empId'
		// ${body['createEmployee']['empId']}, "
		// + "VARCHAR 'firstName' ${body['createEmployee']['firstName']}, "
		// + "VARCHAR 'lastName' ${body['createEmployee']['lastName']}, "
		// + "VARCHAR 'contactNo'
		// ${body['createEmployee']['contactNo']})?dataSource=#dataSource")
		// .process(new Processor() {
		// public void process(Exchange xchg) throws Exception {
		// System.out.println("We are Here !!! ");
		// System.out.println("We are Here !!! ");
		// System.out.println("We are Here !!! ");
		// System.out.println("xchg.getIn().getBody() : - " + xchg.getIn().getBody());
		// System.out
		// .println("xchg.getIn().getBody() : - " +
		// xchg.getIn().getBody().getClass().arrayType());
		// LinkedHashMap<String, Integer> dataList = (LinkedHashMap<String, Integer>)
		// xchg.getIn()
		// .getBody();
		// LinkedHashMap<String, String> hashMap = new LinkedHashMap<String, String>();
		// if (dataList.get("#update-count-1") == 1) {
		// hashMap.put("createEmployee", "Record added in DB successfully!");
		// }
		// xchg.getIn().setBody(hashMap);
		// }
		// });

		// rest("/api").get("/getEmployee").to("direct:getEmployee");

		// // from("direct:addEmployee").log("Headers: - " + "${headers}").log("Headers:
		// - " + "${body}")
		// // .log("body1: - " + "${body['createEmployee']}").log("body2: - " +
		// "${body['createEmployee']['empId']}")
		// // .to("sql-stored:ADD_EMPLOYEE(VARCHAR 'empId'
		// ${body['createEmployee']['empId']}, "
		// // + "VARCHAR 'firstName' ${body['createEmployee']['firstName']}, "
		// // + "VARCHAR 'lastName' ${body['createEmployee']['lastName']}, "
		// // + "VARCHAR 'contactNo'
		// ${body['createEmployee']['contactNo']})?dataSource=#dataSource");
		// from("direct:getEmployee").log("Headers: - " + "${headers}").log("Headers: -
		// " + "${body}")
		// .log("body1: - " + "${body['viewEmployee']}").log("body2: - " +
		// "${body['viewEmployee']['empId']}")
		// .to("sql-stored:GET_EMPLOYEE(VARCHAR 'empId'
		// ${body['viewEmployee']['empId']})?dataSource=#dataSource")
		// .process(new Processor() {
		// public void process(Exchange xchg) throws Exception {
		// System.out.println("We are Here !!! ");
		// System.out.println("We are Here !!! ");
		// System.out.println("We are Here !!! ");
		// System.out.println("xchg.getIn().getBody() : - " + xchg.getIn().getBody());
		// System.out
		// .println("xchg.getIn().getBody() : - " +
		// xchg.getIn().getBody().getClass().arrayType());
		// LinkedHashMap<String, ArrayList<Map<String, String>>> dataList =
		// (LinkedHashMap<String, ArrayList<Map<String, String>>>) xchg
		// .getIn().getBody();
		// List<Employee> employees = new ArrayList<Employee>();
		// System.out.println("dataList: - " + dataList);
		// System.out.println("dataList: - " + dataList);

		// LinkedHashMap<String, List<Employee>> hashMap = new LinkedHashMap<String,
		// List<Employee>>();
		// LinkedHashMap<String, String> emptyHashMap = new LinkedHashMap<String,
		// String>();

		// if (!dataList.get("#result-set-1").isEmpty()) {
		// System.out.println("Hello True");
		// System.out.println("Hello True");
		// System.out.println("Hello True");

		// for (Map<String, String> data : dataList.get("#result-set-1")) {
		// System.out.println("data : - " + data);
		// Employee employee = new Employee();
		// employee.setEmpId(data.get("emp_id"));
		// employee.setFirstName(data.get("first_name"));
		// employee.setLastName(data.get("last_name"));
		// employee.setContactNo(data.get("contact"));
		// System.out.println("employee: - " + employee);
		// employees.add(employee);
		// System.out.println("employees: - " + employees);

		// hashMap.put("GetEmployeeDetails", employees);
		// xchg.getIn().setBody(hashMap);
		// }
		// } else {
		// emptyHashMap.put("GetEmployeeDetails", "Employee Details Not Found!");
		// xchg.getIn().setBody(emptyHashMap);
		// }
		// }
		// });
	}

}
