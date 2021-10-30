module.exports = (sequelize, Sequelize) => {
    const Employee = sequelize.define("employee", {
      fullName: {
        type: Sequelize.STRING
      },
      empCode: {
        type: Sequelize.STRING
      },
      mobile: {
        type: Sequelize.STRING
      }
    });
  
    return Employee;
  };