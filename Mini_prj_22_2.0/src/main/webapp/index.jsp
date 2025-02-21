<!DOCTYPE html>
<%@page import="DAO.RoomDAO"%>
<%@page import="DBConnect.DBConnect"%>
<%@page import="Model.Room"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Tourist - Travel Agency HTML Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />
        <meta content="" name="keywords" />
        <meta content="" name="description" />

        <!-- Favicon -->
        <link href="./img/favicon.png" rel="icon" />

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap"
            rel="stylesheet"
            />

        <!-- Bootstrap CSS -->
    <link
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        rel="stylesheet"
    />
        <!-- Icon Font Stylesheet -->
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
            rel="stylesheet"
            />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
            rel="stylesheet"
            />

        <!-- Libraries Stylesheet -->
        <link href="lib/animate/animate.min.css" rel="stylesheet" />
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet" />
        <link
            href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css"
            rel="stylesheet"
            />


        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet" />

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet" />
    </head>

    <body class="main-color-web">
        <!-- Spinner Start -->
        <div
            id="spinner"
            class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center"
            >
            <div
                class="spinner-border text-primary"
                style="width: 3rem; height: 3rem"
                role="status"
                >
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->

        <!-- Topbar Start -->
        <div class="container-fluid gradient-1 px-5 d-none d-lg-block">
            <div class="row gx-0">
                <div class="col-lg-8 text-center text-lg-start mb-2 mb-lg-0">
                    <div class="d-inline-flex align-items-center" style="height: 45px">
                        <small class="me-3 text-light"
                               ><i class="fa fa-map-marker-alt me-2"></i>Khu ?� th? FPT City, Ng?
                            H�nh S?n, ?� N?ng</small
                        >
                        <small class="me-3 text-light"
                               ><i class="fa fa-phone-alt me-2"></i>+0352736104</small
                        >
                        <small class="text-light"
                               ><i class="fa fa-envelope-open me-2"></i
                            >hoantxde180175@fpt.edu.vn</small
                        >
                    </div>
                </div>
                <div class="col-lg-4 text-center text-lg-end">
                    <div class="d-inline-flex align-items-center" style="height: 45px">
                        <a
                            class="btn btn-sm btn-outline-light btn-sm-square rounded-circle me-2"
                            href="https://x.com/HuyLongDev"
                            rel="noopener"
                            target="_blank"
                            ><i class="fab fa-twitter fw-normal"></i
                            ></a>
                        <a
                            class="btn btn-sm btn-outline-light btn-sm-square rounded-circle me-2"
                            href="https://www.facebook.com/hoa.ngotran.986"
                            rel="noopener"
                            target="_blank"
                            ><i class="fab fa-facebook-f fw-normal"></i
                            ></a>
                        <a
                            class="btn btn-sm btn-outline-light btn-sm-square rounded-circle me-2"
                            href="https://www.linkedin.com/in/th�nh-nguy?n-l�-??ng-834bb8285/"
                            rel="noopener"
                            target="_blank"
                            ><i class="fab fa-linkedin-in fw-normal"></i
                            ></a>
                        <a
                            class="btn btn-sm btn-outline-light btn-sm-square rounded-circle me-2"
                            href="https://www.instagram.com/_.xuho._/"
                            rel="noopener"
                            target="_blank"
                            ><i class="fab fa-instagram fw-normal"></i
                            ></a>
                        <a
                            class="btn btn-sm btn-outline-light btn-sm-square rounded-circle"
                            href="https://github.com/huylongdev"
                            rel="noopener"
                            target="_blank"
                            ><i class="fab fa-github fw-normal"></i
                            ></a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Topbar End -->

        <!-- Navbar & Hero Start -->
        <div class="container-fluid position-relative p-0">
            <nav
                class="navbar navbar-expand-lg navbar-light px-4 px-lg-5 py-3 py-lg-0"
                >
                <a href="" class="navbar-brand p-0">
                    <h1 class="m-0">
                        <div class="wrapper invert">
                            <span data-text="FPT"></span>
                            <span data-text="PARADISE"></span>
                        </div>
                    </h1>
                    <!-- <img src="img/logo.png" alt="Logo"> -->
                </a>
                <button
                    class="navbar-toggler"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#navbarCollapse"
                    >
                    <span class="fa fa-bars"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <div class="navbar-nav ms-auto py-0">
                        <a href="index.jsp" class="nav-item nav-link active">Home</a>
                        <a href="about.html" class="nav-item nav-link">About</a>
                        <a href="service.html?" class="nav-item nav-link">Services</a>
                        <a href="room.jsp" class="nav-item nav-link">Rooms</a>
                        <div class="nav-item dropdown">
                            <a
                                href="#"
                                class="nav-link dropdown-toggle"
                                data-bs-toggle="dropdown"
                                >Pages</a
                            >
                            <div class="dropdown-menu m-0">
                                <a href="destination.html" class="dropdown-item">Destination</a>
                                <a href="booking.html" class="dropdown-item">Booking</a>
                                <a href="team.html" class="dropdown-item">Travel Guides</a>
                                <a href="testimonial.html" class="dropdown-item">Testimonial</a>
                                <a href="404.html" class="dropdown-item">404 Page</a>
                            </div>
                        </div>
                        <a href="contact.html" class="nav-item nav-link">Contact</a>
                    </div>
                </div >
                <div class="nav-item dropdown">
                    <a
                        href="#"
                        class="nav-link dropdown-toggle"
                        data-toggle="dropdown"
                        >
                        <i class="fas fa-user"></i>
                    </a>
                    <div class="dropdown-menu m-0">
                        <a href="#" data-toggle="modal" data-target="#exampleModal" class="dropdown-item">Logout</a>
                        <a href="#" class="drodown-item">Bill</a>
                    </div>
                </div>
        </div>
       
    </nav>
    <div class="container-fluid bg-primary py-5 mb-5 hero-header">
        <div class="container py-5">
            <div class="row justify-content-center py-5">
                <div class="col-lg-10 pt-lg-5 mt-lg-5 text-center">
                    <h1 class="display-3 text-white mb-3 animated slideInDown">
                        Enjoy Your Vacation With FPT Villas
                    </h1>
                    <p class="fs-4 text-white mb-4 animated slideInDown">
                        Modern villas, seamlessly blending with nature.
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Navbar & Hero End -->
 <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" >
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel"></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <h4>Do you want to logout?</h4>
                        <div class="text-center">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <a href="../LogoutController" type="button" class="btn btn-primary">Log out</a>
                        </div>

                    </div>
                    <div class="modal-footer">
                    </div>
                </div>
            </div>
        </div>
        <!-- end modal -->
<!-- About Start -->
<div class="container-xxl py-5">
    <div class="container">
        <div class="row g-5">
            <div
                class="col-lg-6 wow fadeInUp"
                data-wow-delay="0.1s"
                style="min-height: 400px"
                >
                <div class="position-relative h-100 welcome-img">
                    <img
                        class="img-fluid position-absolute w-100 h-100"
                        src="img/about.jpg"
                        alt=""
                        style="object-fit: cover"
                        />
                </div>
            </div>
            <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.3s">
                <h6 class="section-title bg-white text-start text-primary pe-3">
                    About Us
                </h6>
                <h1 class="mb-4 text-primary">
                    ? Welcome to <span class="text-primary">Tourist</span>
                </h1>
                <p class="mb-4">
                    Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit. Aliqu
                    diam amet diam et eos. Clita erat ipsum et lorem et sit.
                </p>
                <p class="mb-4">
                    Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit. Aliqu
                    diam amet diam et eos. Clita erat ipsum et lorem et sit, sed stet
                    lorem sit clita duo justo magna dolore erat amet
                </p>
                <div class="row gy-2 gx-4 mb-4">
                    <div class="col-sm-6">
                        <p class="mb-0">
                            <i class="fa fa-arrow-right text-primary me-2"></i>First Class
                            Flights
                        </p>
                    </div>
                    <div class="col-sm-6">
                        <p class="mb-0">
                            <i class="fa fa-arrow-right text-primary me-2"></i>Handpicked
                            Hotels
                        </p>
                    </div>
                    <div class="col-sm-6">
                        <p class="mb-0">
                            <i class="fa fa-arrow-right text-primary me-2"></i>5 Star
                            Accommodations
                        </p>
                    </div>
                    <div class="col-sm-6">
                        <p class="mb-0">
                            <i class="fa fa-arrow-right text-primary me-2"></i>Latest
                            Model Vehicles
                        </p>
                    </div>
                    <div class="col-sm-6">
                        <p class="mb-0">
                            <i class="fa fa-arrow-right text-primary me-2"></i>150 Premium
                            City Tours
                        </p>
                    </div>
                    <div class="col-sm-6">
                        <p class="mb-0">
                            <i class="fa fa-arrow-right text-primary me-2"></i>24/7
                            Service
                        </p>
                    </div>
                </div>
                <a class="btn btn-color py-3 px-5 mt-2" href="">Read More</a>
            </div>
        </div>
    </div>
</div>
<!-- About End -->

<!-- Service Start -->
<div class="container-xxl py-5">
    <div class="container">
        <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
            <h6 class="section-title bg-white text-center text-primary px-3">Services</h6>
            <h1 class="mb-5 text-primary">Our Services</h1>
        </div>
        <div class="row g-4">
            <div class="col-lg-3 col-sm-6 wow fadeInUp icon-hover-service" data-wow-delay="0.1s">
                <a href="room.jsp" class="nav-item nav-link">
                    <div class="service-item rounded pt-3">
                        <div class="p-4">
                            <i class="fa fa-3x fa-globe text-primary mb-4"></i>
                            <h5>Booking rooms</h5>
                            <p>Available.</p>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-lg-3 col-sm-6 wow fadeInUp icon-hover-service" data-wow-delay="0.3s">
                <a href="404.html" class="nav-item nav-link">
                    <div class="service-item rounded pt-3">
                        <div class="p-4">
                            <i class="fa fa-3x fa-hotel text-primary mb-4"></i>
                            <h5>Booking villa</h5>
                            <p>Still update</p>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-lg-3 col-sm-6 wow fadeInUp icon-hover-service" data-wow-delay="0.5s">
                <a href="404.html" class="nav-item nav-link">
                    <div class="service-item rounded pt-3">
                        <div class="p-4">
                            <i class="fa fa-3x fa-user text-primary mb-4"></i>
                            <h5>Travel Guides</h5>
                            <p>Still update</p>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-lg-3 col-sm-6 wow fadeInUp icon-hover-service" data-wow-delay="0.7s">
                <a href="404.html" class="nav-item nav-link">
                    <div class="service-item rounded pt-3">
                        <div class="p-4">
                            <i class="fa fa-3x fa-cog text-primary mb-4"></i>
                            <h5>Other booking</h5>
                            <p>Still update</p>
                        </div>
                    </div>
                </a>
            </div>
        </div>
    </div>
</div>


<!-- Service End -->

<!-- Destination Start -->
<div class="container-xxl py-5 destination">
    <div class="container">
        <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
            <h6 class="section-title bg-white text-center text-primary px-3">
                Destination
            </h6>
            <h1 class="mb-5 text-primary">Popular Destination</h1>
        </div>
        <div class="row g-3">
            <div class="col-lg-7 col-md-6">
                <div class="row g-3">
                    <div class="col-lg-12 col-md-12 wow zoomIn" data-wow-delay="0.1s">
                        <a class="position-relative d-block overflow-hidden" href="">
                            <img class="img-fluid" src="img/destination-1.jpg" alt="" />

                            <div
                                class="bg-white text-primary fw-bold position-absolute bottom-0 end-0 m-3 py-1 px-2"
                                >
                                Standard
                            </div>
                        </a>
                    </div>
                    <div class="col-lg-6 col-md-12 wow zoomIn" data-wow-delay="0.3s">
                        <a class="position-relative d-block overflow-hidden" href="">
                            <img class="img-fluid" src="img/destination-2.jpg" alt="" />

                            <div
                                class="bg-white text-primary fw-bold position-absolute bottom-0 end-0 m-3 py-1 px-2"
                                >
                                Premium
                            </div>
                        </a>
                    </div>
                    <div class="col-lg-6 col-md-12 wow zoomIn" data-wow-delay="0.5s">
                        <a class="position-relative d-block overflow-hidden" href="">
                            <img class="img-fluid" src="img/destination-3.jpg" alt="" />

                            <div
                                class="bg-white text-primary fw-bold position-absolute bottom-0 end-0 m-3 py-1 px-2"
                                >
                                Deluxe
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <div
                class="col-lg-5 col-md-6 wow zoomIn"
                data-wow-delay="0.7s"
                style="min-height: 350px"
                >
                <a class="position-relative d-block h-100 overflow-hidden" href="">
                    <img
                        class="img-fluid position-absolute w-100 h-100"
                        src="img/destination-4.jpg"
                        alt=""
                        style="object-fit: cover"
                        />

                    <div
                        class="bg-white text-primary fw-bold position-absolute bottom-0 end-0 m-3 py-1 px-2"
                        >
                        Premium
                    </div>
                </a>
            </div>
        </div>
    </div>
</div>
<!-- Destination Start -->

<!-- Room Start -->
<div class="container-xxl py-5">
    <div class="container">
        <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
            <h6 class="section-title bg-white text-center text-primary px-3">Rooms</h6>
            <h1 class="mb-5">Awesome Rooms</h1>
        </div>

        <div class="row g-4 justify-content-center">
            <%
                RoomDAO dao = new RoomDAO(DBConnect.getConn());
                List<Room> list = dao.Rooms();
                for (int i = 1; i < 4; i++) {
                    Room room = list.get(i);
            %>
            <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                <div class="room-item">
                    <div class="overflow-hidden">
                        <img class="img-fluid" src="img/room-1.jpg" alt="">
                    </div>

                    <div class="d-flex border-bottom">
                        <small class="flex-fill text-center border-end py-2"><i class="fa fa-map-marker-alt text-primary me-2"></i><%=room.getRoomtype()%></small>
                        <small class="flex-fill text-center border-end py-2"><i class="fa fa-calendar-alt text-primary me-2"></i>...</small>
                        <small class="flex-fill text-center py-2"><i class="fa fa-user text-primary me-2"></i><%=room.getCapacity()%></small>
                    </div>
                    <div class="text-center p-4">
                        <h3 class="mb-0">$<%=room.getPrice()%> per night</h3>
                        <div class="mb-3">
                            <small class="fa fa-star text-primary"></small>
                            <small class="fa fa-star text-primary"></small>
                            <small class="fa fa-star text-primary"></small>
                            <small class="fa fa-star text-primary"></small>
                            <small class="fa fa-star text-primary"></small>
                        </div>
                        <p>Cozy room with essential amenities, perfect for a comfortable stay with a garden view.</p>
                        <div class="d-flex justify-content-center mb-2">
                            <form action="BillController" method="post">
                                <input type="hidden" name="roomId" value="<%= room.getRoomId()%>">
                                <label for="checkin">Check-in:</label>
                                <input type="date" name="checkin" required>
                                <br>
                                <label for="checkout">Check-out:</label>
                                <input type="date" name="checkout" required>
                                <br>
                                <button type="submit" class="btn btn-sm btn-color p-sm-2 px-3" style="border-radius: 30px">Book Now</button>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
            <%
                }
            %>
        </div>
        <a href="room.jsp" >More</a>

    </div>
</div>
<!-- Room End -->

<!-- Booking Start -->
<!-- Booking Start -->

<!-- Process Start -->
<div class="container-xxl py-5">
    <div class="container">
        <div class="text-center pb-4 wow fadeInUp" data-wow-delay="0.1s">
            <h6 class="section-title bg-white text-center text-primary px-3">
                Process
            </h6>
            <h1 class="mb-5 text-primary">3 Easy Steps</h1>
        </div>
        <div class="row gy-5 gx-4 justify-content-center">
            <div
                class="col-lg-4 col-sm-6 text-center pt-4 wow fadeInUp"
                data-wow-delay="0.1s"
                >
                <div class="position-relative border border-primary pt-5 pb-4 px-4">
                    <div
                        class="d-inline-flex align-items-center justify-content-center bg-primary rounded-circle position-absolute top-0 start-50 translate-middle shadow"
                        style="width: 100px; height: 100px"
                        >
                        <i class="fa fa-globe fa-3x text-white"></i>
                    </div>
                    <h5 class="mt-4">Choose A Destination</h5>
                    <hr class="w-25 mx-auto bg-primary mb-1" />
                    <hr class="w-50 mx-auto bg-primary mt-0" />
                    <p class="mb-0">
                        Explore a world of possibilities with our wide selection of
                        destinations. Whether you crave beaches, cities, or countryside
                        retreats, find your perfect spot easily with our advanced search
                        tools and detailed destination guides.
                    </p>
                </div>
            </div>
            <div
                class="col-lg-4 col-sm-6 text-center pt-4 wow fadeInUp"
                data-wow-delay="0.3s"
                >
                <div class="position-relative border border-primary pt-5 pb-4 px-4">
                    <div
                        class="d-inline-flex align-items-center justify-content-center bg-primary rounded-circle position-absolute top-0 start-50 translate-middle shadow"
                        style="width: 100px; height: 100px"
                        >
                        <i class="fa fa-dollar-sign fa-3x text-white"></i>
                    </div>
                    <h5 class="mt-4">Pay Online</h5>
                    <hr class="w-25 mx-auto bg-primary mb-1" />
                    <hr class="w-50 mx-auto bg-primary mt-0" />
                    <p class="mb-0">
                        Enjoy a hassle-free payment process with our secure online
                        system. Choose your preferred payment method and complete your
                        booking with confidence. Instant confirmation ensures you're
                        ready to go.
                    </p>
                </div>
            </div>
            <div
                class="col-lg-4 col-sm-6 text-center pt-4 wow fadeInUp"
                data-wow-delay="0.5s"
                >
                <div class="position-relative border border-primary pt-5 pb-4 px-4">
                    <div
                        class="d-inline-flex align-items-center justify-content-center bg-primary rounded-circle position-absolute top-0 start-50 translate-middle shadow"
                        style="width: 100px; height: 100px"
                        >
                        <i class="fa fa-plane fa-3x text-white"></i>
                    </div>
                    <h5 class="mt-4">Fly Today</h5>
                    <hr class="w-25 mx-auto bg-primary mb-1" />
                    <hr class="w-50 mx-auto bg-primary mt-0" />
                    <p class="mb-0">
                        Book now and fly today! Our streamlined process lets you secure
                        a flight quickly, even for last-minute plans. Check in online,
                        pack your bags, and get ready to embark on your adventure.Hope
                        you enjoy the services
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Process Start -->

<!-- Team Start -->
<div class="container-xxl py-5">
    <div class="container">
        <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
            <h6 class="section-title bg-white text-center text-primary px-3">
                Fouder & Co-Founder
            </h6>
            <h1 class="mb-5">Meet Our Founders</h1>
        </div>
        <div class="row g-4">
            <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                <div class="team-item">
                    <div class="overflow-hidden">
                        <img class="img-fluid" src="img/team-1.jpg" alt="" />
                    </div>
                    <div
                        class="position-relative d-flex justify-content-center"
                        style="margin-top: -19px"
                        >
                        <a
                            class="btn btn-square mx-1"
                            href="https://github.com/huylongdev"
                            rel="noopener"
                            target="_blank"
                            ><i class="fab fa-github"></i
                            ></a>
                    </div>
                    <div class="text-center p-4">
                        <h5 class="mb-0">Ng� Huy Long</h5>
                        <small>FE DEVELOPER</small>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
                <div class="team-item">
                    <div class="overflow-hidden">
                        <img class="img-fluid" src="img/team-2.jpg" alt="" />
                    </div>
                    <div
                        class="position-relative d-flex justify-content-center"
                        style="margin-top: -19px"
                        >
                        <a
                            class="btn btn-square mx-1"
                            href="https://github.com/XuHo-IT"
                            rel="noopener"
                            target="_blank"
                            ><i class="fab fa-github"></i
                            ></a>
                    </div>
                    <div class="text-center p-4">
                        <h5 class="mb-0">Ng� Tr?n Xu�n Ho�</h5>
                        <small>BE DEVELOPER</small>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
                <div class="team-item">
                    <div class="overflow-hidden">
                        <img class="img-fluid" src="img/team-3.jpg" alt="" />
                    </div>
                    <div
                        class="position-relative d-flex justify-content-center"
                        style="margin-top: -19px"
                        >
                        <a
                            class="btn btn-square mx-1"
                            href="https://github.com/thanhnld0912"
                            rel="noopener"
                            target="_blank"
                            ><i class="fab fa-github"></i
                            ></a>
                    </div>
                    <div class="text-center p-4">
                        <h5 class="mb-0">Nguy?n L� ??ng Th�nh</h5>
                        <small>Game Developer</small>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.7s">
                <div class="team-item">
                    <div class="overflow-hidden">
                        <img class="img-fluid" src="img/team-4.jpg" alt="" />
                    </div>
                    <div
                        class="position-relative d-flex justify-content-center"
                        style="margin-top: -19px"
                        >
                        <a class="btn btn-square mx-1" href=""
                           ><i class="fab fa-facebook-f"></i
                            ></a>
                        <a class="btn btn-square mx-1" href=""
                           ><i class="fab fa-twitter"></i
                            ></a>
                        <a class="btn btn-square mx-1" href=""
                           ><i class="fab fa-instagram"></i
                            ></a>
                    </div>
                    <div class="text-center p-4">
                        <h5 class="mb-0">Full Name</h5>
                        <small>Designation</small>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Team End -->

<!-- Testimonial Start -->
<div class="container-xxl py-5 wow fadeInUp" data-wow-delay="0.1s">
    <div class="container">
        <div class="text-center">
            <h6 class="section-title bg-white text-center text-primary px-3">
                Testimonial
            </h6>
            <h1 class="mb-5">Our Customers Feedback</h1>
        </div>
        <div class="owl-carousel testimonial-carousel position-relative">
            <div class="testimonial-item bg-white text-center border p-4">
                <img
                    class="bg-white rounded-circle shadow p-1 mx-auto mb-3"
                    src="img/testimonial-1.jpg"
                    style="width: 80px; height: 80px"
                    />
                <h5 class="mb-0">Jeong "Chovy"</h5>
                <p>Busan, Korea</p>
                <p class="mb-0">
                    Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam
                    amet diam et eos. Clita erat ipsum et lorem et sit.
                </p>
            </div>
            <div class="testimonial-item bg-white text-center border p-4">
                <img
                    class="bg-white rounded-circle shadow p-1 mx-auto mb-3"
                    src="img/testimonial-2.jpg"
                    style="width: 80px; height: 80px"
                    />
                <h5 class="mb-0">Lee Sang "Faker"</h5>
                <p>Seoul, Korea</p>
                <p class="mt-2 mb-0">
                    Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam
                    amet diam et eos. Clita erat ipsum et lorem et sit.
                </p>
            </div>
            <div class="testimonial-item bg-white text-center border p-4">
                <img
                    class="bg-white rounded-circle shadow p-1 mx-auto mb-3"
                    src="img/testimonial-3.jpg"
                    style="width: 80px; height: 80px"
                    />
                <h5 class="mb-0">"Ba" Teacher</h5>
                <p>HoChiMinh, Viet Nam</p>
                <p class="mt-2 mb-0">
                    Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam
                    amet diam et eos. Clita erat ipsum et lorem et sit.
                </p>
            </div>
            <div class="testimonial-item bg-white text-center border p-4">
                <img
                    class="bg-white rounded-circle shadow p-1 mx-auto mb-3"
                    src="img/testimonial-4.jpg"
                    style="width: 80px; height: 80px"
                    />
                <h5 class="mb-0">Min-hyeong "Gumayushi"</h5>
                <p>Seoul, Korea</p>
                <p class="mt-2 mb-0">
                    Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam
                    amet diam et eos. Clita erat ipsum et lorem et sit.
                </p>
            </div>
        </div>
    </div>
</div>
<!-- Testimonial End -->

<!-- Footer Start -->
<div
    class="container-fluid gradient-1 text-light footer pt-5 mt-5 wow fadeIn"
    data-wow-delay="0.1s"
    >
    <div class="container py-5">
        <div class="row g-5">
            <div class="col-lg-3 col-md-6">
                <h4 class="text-white mb-3">Company</h4>
                <a class="btn btn-link" href="">About Us</a>
                <a class="btn btn-link" href="">Contact Us</a>
                <a class="btn btn-link" href="">Privacy Policy</a>
                <a class="btn btn-link" href="">Terms & Condition</a>
                <a class="btn btn-link" href="">FAQs & Help</a>
            </div>
            <div class="col-lg-3 col-md-6">
                <h4 class="text-white mb-3">Contact</h4>
                <p class="mb-2">
                    <i class="fa fa-map-marker-alt me-3"></i>123 Street, New York, USA
                </p>
                <p class="mb-2">
                    <i class="fa fa-phone-alt me-3"></i>+012 345 67890
                </p>
                <p class="mb-2">
                    <i class="fa fa-envelope me-3"></i>info@example.com
                </p>
                <div class="d-flex pt-2">
                    <a class="btn btn-outline-light btn-social" href=""
                       ><i class="fab fa-twitter"></i
                        ></a>
                    <a class="btn btn-outline-light btn-social" href=""
                       ><i class="fab fa-facebook-f"></i
                        ></a>
                    <a class="btn btn-outline-light btn-social" href=""
                       ><i class="fab fa-github"></i
                        ></a>
                    <a class="btn btn-outline-light btn-social" href=""
                       ><i class="fab fa-linkedin-in"></i
                        ></a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <h4 class="text-white mb-3">Gallery</h4>
                <div class="row g-2 pt-2">
                    <div class="col-4">
                        <img
                            class="img-fluid bg-light p-1"
                            src="img/room-1.jpg"
                            alt=""
                            />
                    </div>
                    <div class="col-4">
                        <img
                            class="img-fluid bg-light p-1"
                            src="img/room-2.jpg"
                            alt=""
                            />
                    </div>
                    <div class="col-4">
                        <img
                            class="img-fluid bg-light p-1"
                            src="img/room-3.jpg"
                            alt=""
                            />
                    </div>
                    <div class="col-4">
                        <img
                            class="img-fluid bg-light p-1"
                            src="img/room-2.jpg"
                            alt=""
                            />
                    </div>
                    <div class="col-4">
                        <img
                            class="img-fluid bg-light p-1"
                            src="img/room-3.jpg"
                            alt=""
                            />
                    </div>
                    <div class="col-4">
                        <img
                            class="img-fluid bg-light p-1"
                            src="img/room-1.jpg"
                            alt=""
                            />
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <h4 class="text-white mb-3">Newsletter</h4>
                <p>Dolor amet sit justo amet elitr clita ipsum elitr est.</p>
                <div class="position-relative mx-auto" style="max-width: 400px">
                    <input
                        class="form-control border-primary w-100 py-3 ps-4 pe-5"
                        type="text"
                        placeholder="Your email"
                        />
                    <button
                        type="button"
                        class="btn btn-color   py-2 position-absolute top-0 end-0 mt-2 me-2"
                        >
                        SignUp
                    </button>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="copyright">
            <div class="row">
                <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                    &copy; <a class="border-bottom" href="#">Your Site Name</a>, All
                    Right Reserved.

                    <!--/*** This template is free as long as you keep the footer author?s credit link/attribution link/backlink. If you'd like to use the template without the footer author?s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                    Designed By
                    <a class="border-bottom" href="https://htmlcodex.com"
                       >HTML Codex</a
                    >
                </div>
                <div class="col-md-6 text-center text-md-end">
                    <div class="footer-menu">
                        <a href="">Home</a>
                        <a href="">Cookies</a>
                        <a href="">Help</a>
                        <a href="">FQAs</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer End -->

<!-- Back to Top -->
<a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"
   ><i class="bi bi-arrow-up"></i
    ></a>

<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="lib/wow/wow.min.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="lib/waypoints/waypoints.min.js"></script>
<script src="lib/owlcarousel/owl.carousel.min.js"></script>
<script src="lib/tempusdominus/js/moment.min.js"></script>
<script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
<script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

<!-- Template Javascript -->
<script src="js/main.js"></script>
</body>
</html>
