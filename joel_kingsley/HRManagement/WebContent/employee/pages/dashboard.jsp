<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="io.ztech.jkingsley.hrmanagement.beans.objects.Profile"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300,300i,700" rel="stylesheet"> 
    <link rel="stylesheet" href="/HR_Management/general/css/fonts.css">
    <link rel="stylesheet" href="/HR_Management/general/css/header.css">
    <link rel="stylesheet" href="/HR_Management/general/css/footer.css">
    <link rel="stylesheet" href="/HR_Management/general/css/buttons.css">
    <link rel="stylesheet" href="/HR_Management/general/css/navbar.css">
    <link rel="stylesheet" href="/HR_Management/general/css/call.css">
    <link rel="stylesheet" href="/HR_Management/general/css/colors.css">
    <link rel="stylesheet" href="/HR_Management/general/css/dashboard.css">
    <title>Grievance Tracker | ZTech HRManagement</title>
</head>
<body>
    <header>
        <div id="ztech-logo">
            <img src="/HR_Management/assets/img/hr-logo.png">
        </div>
        <div class="drop">
            <div class="drop-image" id="drop-image">
                <img src="/HR_Management/assets/img/joel.jpeg">
            </div>

            <div name="drop-menu" class="drop-menu" id="drop-menu">
                <div class="drop-menu-content">
                    <button name="logout" class="logout open-sans-condensed white bold">Log Out</button>
                </div>
            </div>

            <div class="drop-text open-sans-condensed italics">
            
            </div>
        </div>
    </header>
    <section class="navbar">
        <div class="open-sans-condensed bold">
            <a href="/HR_Management/dashboard" class="active menu-button">Dashboard</a>
            <div class="dropdown-content dashboard-drop">
                <a href="/HR_Management/dashboard/profile">Profile</a>
                <a href="/HR_Management/employee/pages/projects.jsp">Project</a>
                <a href="/HR_Management/employee/pages/documents.jsp">Documents</a>
            </div>
        </div>
        <div class="open-sans-condensed bold">
            <a href="/HR_Management/leave-tracker" class="menu-button">Leave Tracker</a>
            <div class="dropdown-content lt-drop">
                <a href="/HR_Management/employee/pages/apply-leave.jsp">Apply Leave</a>
                <a href="/HR_Management/employee/pages/leave-log.jsp">Leave Log</a>
            </div>
        </div>
        <div class="open-sans-condensed bold">
            <a href="/HR_Management/employee/pages/grievance-tracker.jsp" class="menu-button">Grievance Tracker</a>
            <div class="dropdown-content gt-drop">
                <a href="/HR_Management/employee/pages/issue-grievance.jsp">Issue Grievance</a>
                <a href="/HR_Management/employee/pages/grievance-log.jsp">Grievance Log</a>
            </div>
        </div>
        <input type="text" placeholder="Search..." class="open-sans-condensed">
    </section>
    <section class="middle">
        <img src="/HR_Management/assets/img/construction-helmet.png">
    </section>
        <footer>
                <%
                    Profile profile = (Profile) session.getAttribute("profile");
                    out.println(profile.getEmployee().getEmp_name());
                %>
        </footer>
        <script type="text/javascript" src="/HR_Management/general/js/header.js"></script>
</body>
</html>