<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>FitnessFirst-Calorie calculator</title>
<meta name="viewport" content="width=device-width, initial-scale=1">


<link href='https://fonts.googleapis.com/css?family=Kalam'
	rel='stylesheet'>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/css?family=Bubblegum+Sans" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/anonpagestyle.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/gridstylesheet.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/caloriepagestyle.css">

</head>

<body>
	<header class="row">
		<div class="logo-box col-sm-10 col-md-6 col-lg-3">
			<div class="logo-image-box">
				<img src="${pageContext.request.contextPath}/assets/logo-img1.png" alt="logo">
			</div>

			<div class="logo-name-box">
				<div class="logo-text-box row">Fit 'n Flair</div>
				<div class="logo-subtext-box row">Your Diet Companion</div>
			</div>
		</div>

		<div class="login-signup-wrapper col-sm-12 col-md-6 col-lg-3">
			<div class="login-box">
				<button onclick="showLogInBox()">Login</button>
			</div>
			<div class="signup-box">
				<a href="/FitnessFirstPrototype/SignupPageServlet">
					<button>Sign up</button>
				</a>
			</div>
		</div>
	</header>

	<div class="modal row" style="display: none">
		<div class="modal-content-box col-sm-12 col-md-8 col-lg-4">
			<button onclick="closeLoginBox()">&#10006</button>

			<div>LOGIN</div>
			<form name="loginform">
				<div>
					<input type="text" placeholder="Username" name="username">
				</div>

				<div>
					<input type="password" placeholder="Password" name="password">
				</div>

				<div>
					<input type="button" value="Login" id="loginbutton">
				</div>

				<div id="error-text"></div>

			</form>
		</div>
	</div>



	<div class="wrapper row">
		<div class="navbar col-sm-12 col-md-3 col-lg-2">
			<ul>
				<li><a href="index.jsp">Home</a></li>
				<li><a href="BmiServlet">BMI calculator</a></li>
				<li><a href="BmrServlet">BMR calculator</a></li>
				<li><a href="CalorieCalculatorServlet">Calorie calculator</a></li>
			</ul>

		</div>
		<div class="main-wrapper col-sm-12 col-md-9 col-lg-10">
			<div class="description">
				<h3>What are Calories?</h3>
				<p>Calories are a measure of energy and are commonly used to
					describe the energy content of foods. Your body is able to break
					down food molecules and use the stored energy for many different
					functions, including movement, thought and growth. Calories also
					play a role in weight control, because eating more calories than
					your body needs can lead to weight gain.</p>
			</div>
			<div class="description">
				<h3>Why Are Calories Important?</h3>
				<p>Calories are units of energy, contained within food, and used
					by the human body to maintain daily health and life. Calories are
					associated with energy that is contained in protein, carbohydrates
					and fat. Within each of these measures, calories will have a given
					amount of energy available. Different foods will provide different
					amounts of calories. In addition to this, the other nutrients
					needed for the human body will also differ according to the foods
					being eaten. The human body will burn calories in order to remain
					healthy and balanced. This is by the metabolism moving calories
					through your body. Your metabolism may also turn calories into
					proteins or amino acids if the body needs it. These calories then
					move into the bloodstream and turn into cells or become stored
					energy. The energy your body needs in order to stay healthy and
					alive is directly related to the number of calories you intake
					(eat). The inverse is also true, too many calories consumed can
					lead to weight problems and poor health.</p>
				<p>Calories are a measure of energy and are commonly used to
					describe the energy content of foods. Your body is able to break
					down food molecules and use the stored energy for many different
					functions, including movement, thought and growth. Calories also
					play a role in weight control, because eating more calories than
					your body needs can lead to weight gain.</p>
			</div>

			<div class="calculator-box">
				<div class="calculator-box_input-wrapper">
					<div class="calculator-box_input">
						<h3>Calorie Calculator</h3>
						<form name="food-form" class="row">
							<div class="col-sm-12 col-md-6 col-lg-6">
								Enter food name <input type="text" name="food-input"
									class="food-input-box" placeholder="Enter keywords to search">
								<div class="food-suggestion-list"></div>
							</div>

							<div class="col-sm-12 col-md-6 col-lg-6">
								<div>
									Serving size &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
										type="text" name="serving-input">
								</div>
								<div>
									Enter quantity &nbsp;&nbsp;&nbsp;&nbsp;<input type="number"
										name="quantity-input">
								</div>
								<input type="button" value="Add To List" name="add-button">
							</div>

						</form>

					</div>
					<div class="calculator-box_input-list">
						<h3>Selected Foods List</h3>
						<div>
							<span>FoodItem</span> <span>Quantity</span> <span>Serving
								size</span> <span>Calories per serving</span> <span>Total
								Calories</span>
						</div>
						<div class="selected-food-list"></div>
						<button onclick=calculateTotal()>Done</button>

					</div>

				</div>
				<div class="calculator-box_result-wrapper"></div>
				<div class="note">Once you are done adding all items, click
					"Done" to calculate total calories</div>
				<div class="note">*If you cannot find the food you are looking
					for, kindly suggest them in the box below.</div>
			</div>


		</div>
	</div>

	<footer class="row">
		<div class="link-box row">
			<div class="link-box_social col-sm-12 col-md-12 col-lg-12">
				<i class="fab fa-facebook-f"></i> <i class="fab fa-twitter"></i> <i
					class="fab fa-instagram"></i> <i class="fab fa-blogger"></i>
			</div>
		</div>
		<div class="copyright-box col-sm-12 col-md-12 col-lg-12">
			<p>2018 © Fit 'n Flair, Inc.</p>
		</div>
	</footer>

	<script src="${pageContext.request.contextPath}/js/caloriepagescript.js"></script>
	<script src="${pageContext.request.contextPath}/js/loginmodalscript.js"></script>
	<script src="${pageContext.request.contextPath}/js/loginvalidation.js"></script>

</body>

</html>