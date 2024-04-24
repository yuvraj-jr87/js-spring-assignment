// IBM FSD Demo App
console.log("IBM FSD Demo App");

const restUrl = "http://localhost:8081/";

// ---

const findAllEmployees = () => {
  fetch(restUrl + "emp/get-all-emps")
    .then((res) => res.json())
    .then((resp) => printAllData(resp))
    .catch((error) => console.log(error));
};

const printAllData = (arr) => {
  for (let i = 0; i < arr.length; i++) {
    let employeeInfo = document.createElement("div");
    employeeInfo.textContent = `${i + 1}       First Name: ${
      arr[i].firstName
    }       Salary: ${arr[i].salary}     Email: ${arr[i].email}`;
    document.getElementById("allEmps").appendChild(employeeInfo);
  }
};

// ======================================================

const findEmployeeById = () => {
  const employeeId = document.getElementById("empId").value;
  fetch(restUrl + "emp/get-emp-by-id/" + employeeId)
    .then((res) => res.json())
    .then((resp) => printDataById(resp))
    .catch((error) => console.log(error));
};
const printDataById = (data) => {
  let employeeInfo = document.createElement("div");
  employeeInfo.textContent = `ID:${data.employeeId}       First Name: ${data.firstName}       Salary: ${data.salary}     Email: ${data.email}`;
  document.getElementById("getEmpById").appendChild(employeeInfo);
};

// =====================================================

const findEmployeeByName = () => {
    const firstName = document.getElementById("empName").value;
  fetch(restUrl + "emp/get-emp-by-name/" + firstName)
    .then((res) => res.json())
    .then((resp) => printDataByName(resp))
    .catch((error) => console.log(error));
};
const printDataByName = (arr) => {
    for (let i = 0; i < arr.length; i++) {
        let employeeInfo = document.createElement("div");
        employeeInfo.textContent = ` First Name: ${
          arr[i].firstName
        }       Salary: ${arr[i].salary}     Email: ${arr[i].email}`;
        document.getElementById("getEmpByName").appendChild(employeeInfo);
      }
  };

// =====================================================

const addEmployee = () => {
    const firstName = document.getElementById("employeeName").value;
    const salary= document.getElementById("employeeSalary").value;
    const email = document.getElementById("employeeMail").value;
    let employee={firstName:firstName,salary:salary,email:email};

    fetch(restUrl+"emp/add-emp", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(employee),
      })
        .then((res) => res.json())
        .then((resp) => console.log(resp))
        .catch((error) => console.log(error));
};


// =====================================================
const updateEmployee = () => {
    let employee={};
    const employeeId = document.getElementById("upempId").value;
    const firstName = document.getElementById("upemployeeName").value;
    if (firstName!=""){
        employee['firstName'] = firstName;
    }
    const salary= document.getElementById("upemployeeSalary").value;
    if (salary!=null){
        employee['salary'] = salary;
    }
    const email = document.getElementById("upemployeeMail").value;
    if (email!=""){
        employee['email'] = email;
    }

    // let employee={firstName:firstName,salary:salary,email:email};
    fetch(restUrl+"emp/update-emp/"+employeeId, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(employee),
      })
        .then((res) => res.json())
        .then((resp) => console.log(resp))
        .catch((error) => console.log(error));
};



// =====================================================

const deleteEmployee = () => {
    const employeeId = document.getElementById("delEmpId").value;
  fetch(restUrl + "emp/delete-emp/" + employeeId, {
    method: "DELETE"
  })
    .then((res) => console.log("Deleted"))
    .catch((error) => console.log(error));
};

