Page Title: Instructor SSO - Create / Edit Course
        

#Object Definitions
====================================================================================
inputCourseName							css  								.courseName
inputBeginDate							css    								#beginDate
inputEndDate							css									#endDate
btnCreateCourse							xpath								//a[contains(text(),'Create Course')]
btnAddInstructorTA						css									.linkAddInstructor
inputEmailId							css									#instructorEmail
btnAdd									css									#AddButton
btnSaveChanges							xpath								//a[contains(text(),'Save Changes')]



====================================================================================
@all, browsers
--------------------------------
inp_password
    below: inp_username 10 px
    hover: css 

@all
--------------------------------
inp_password
    above: inp_username 10 px

@browser
--------------------------------
inp_password
    below: inp_username > 10 px