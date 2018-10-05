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
    <link rel="stylesheet" href="/HR_Management/general/css/leave-tracker.css">
    <title>Leave Tracker | ZTech HRManagement</title>
</head>
<body>
    <header>
        <div id="ztech-logo">
            <img src="/HR_Management/assets/img/hr-logo.png">
        </div>
        <div class="drop">
            <div class="drop-image">
                <img src="/HR_Management/assets/img/joel.jpeg">
            </div>
            <div class="drop-text open-sans-condensed italics">
                Joel Kingsley
            </div>
        </div>
    </header>
    <section class="navbar">
        <div class="open-sans-condensed bold">
            <a href="/HR_Management/manager/pages/dashboard.jsp" class="menu-button">Dashboard</a>
            <div class="dropdown-content dashboard-drop">
                <a href="/HR_Management/general/pages/profile.jsp">Profile</a>
                <a href="/HR_Management/manager/pages/projects.jsp">Project</a>
                <a href="/HR_Management/manager/pages/documents.jsp">Documents</a>
            </div>
        </div>
        <div class="open-sans-condensed bold">
            <a href="/HR_Management/manager/pages/leave-tracker.jsp" class="active menu-button">Leave Tracker</a>
            <div class="dropdown-content lt-drop">
                <a href="/HR_Management/manager/pages/apply-leave.jsp">Apply Leave</a>
                <a href="/HR_Management/manager/pages/leave-log.jsp">Leave Log</a>
            </div>
        </div>
        <div class="open-sans-condensed bold">
            <a href="/HR_Management/manager/pages/grievance-tracker.jsp" class="menu-button">Grievance Tracker</a>
            <div class="dropdown-content gt-drop">
                <a href="/HR_Management/manager/pages/issue-grievance.jsp">Issue Grievance</a>
                <a href="/HR_Management/manager/pages/grievance-log.jsp">Grievance Log</a>
            </div>
        </div>
        <input type="text" placeholder="Search..." class="open-sans-condensed">
    </section>
        <section class="middle">
            <div id="first-container" class="col-sm-12 col-md-6">
                    <div id="apply-leave" class="col-sm-11 col-md-12">
                        <h1 class="open-sans-condensed bold white">
                            Apply Leave
                        </h1>
                    </div>
                    <div id="leave-log" class="col-sm-11 col-md-12">
                        <h1 class="open-sans-condensed bold white">
                            Leave Requests
                        </h1>
                        <div id="leave-item" class="open-sans-condensed">
                            <div id="employee-details" class="bold">
                                Joel Kingsley (2034)
                            </div>
                            <div id="leave-reason" class="bold">
                                For attending a marriage
                            </div>
                            <div id="leave-period">
                                12/01/2018
                            </div>
                        </div>
                        <div id="leave-item" class="open-sans-condensed">
                            <div id="employee-details" class="bold">
                                Joel Kingsley (2034)
                            </div>
                            <div id="leave-reason" class="bold">
                                High Fever
                            </div>
                            <div id="leave-period">
                                16/01/2018 - 17/01/2018
                            </div>
                        </div>
                        <div id="leave-item" class="open-sans-condensed">
                            <div id="employee-details" class="bold">
                                Joel Kingsley (2034)
                            </div>
                            <div id="leave-reason" class="bold">
                                High Fever
                            </div>
                            <div id="leave-period">
                                16/01/2018 - 17/01/2018
                            </div>
                        </div>
                        <div id="more" class="open-sans-condensed italics white">
                            <a href="../pages/leave-log.jsp">More</a>
                        </div>
                    </div>
            </div>
            <div id="second-container" class="col-sm-12 col-md-6">
                <div id="leave-log" class="col-sm-11 col-md-12">
                    <h1 class="open-sans-condensed bold white">
                        Leave Log
                    </h1>
                    <div id="leave-item" class="open-sans-condensed">
                        <div id="employee-details" class="bold">
                            Joel Kingsley (2034)
                        </div>
                        <div id="leave-reason" class="bold">
                            For attending a marriage
                        </div>
                        <div id="leave-period">
                            12/01/2018
                        </div>
                    </div>
                    <div id="leave-item" class="open-sans-condensed">
                        <div id="employee-details" class="bold">
                            Joel Kingsley (2034)
                        </div>
                        <div id="leave-reason" class="bold">
                            High Fever
                        </div>
                        <div id="leave-period">
                            16/01/2018 - 17/01/2018
                        </div>
                    </div>
                    <div id="leave-item" class="open-sans-condensed">
                        <div id="employee-details" class="bold">
                            Joel Kingsley (2034)
                        </div>
                        <div id="leave-reason" class="bold">
                            High Fever
                        </div>
                        <div id="leave-period">
                            16/01/2018 - 17/01/2018
                        </div>
                    </div>
                    <div id="more" class="open-sans-condensed italics white">
                        <a href="../pages/leave-log.jsp">More</a>
                    </div>
                </div>
            </div>
        </section>
        <footer>
            
        </footer>
</body>
</html>