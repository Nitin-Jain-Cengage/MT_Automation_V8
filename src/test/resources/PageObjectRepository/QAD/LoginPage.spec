Page Title: MindTap Login

#Object Definitions
====================================================================================

inp_username    css #_username_id
inp_password    css #_password_id

btn_signin      css input.goButton
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