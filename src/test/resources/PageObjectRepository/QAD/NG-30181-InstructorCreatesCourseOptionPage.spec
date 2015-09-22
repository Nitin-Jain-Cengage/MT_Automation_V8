Page Title: Instructor SSO - Create Course Option
        

#Object Definitions
====================================================================================
createNewCourse					xpath							//input[@ id="createNewCourse"]
btnContinue						xpath							//a[contains(text(),"Continue")]
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