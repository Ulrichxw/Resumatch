
# **RESUMATCH**
### AI-Powered Job Matching and Resume Generation Platform

---
# ResuMatch

### AI-Powered Job Matching and Resume Generation Platform

## 1. Project Title

**ResuMatch: AI-Powered Job Matching and Resume Generation Platform**

## 2. Project Description

ResuMatch is a web-based platform designed to simplify the job application and recruitment process by connecting job seekers with suitable employment opportunities. It allows applicants to create profiles containing their educational background, work experience, achievements, certifications, soft skills, and hard skills.

Using the information stored in their profiles, applicants can generate customized resumes tailored to specific job positions through the Gemini API. The system also recommends job vacancies based on their qualifications and skills.

Additionally, employers can publish job openings and manage applications, while administrators review and approve job postings before they become available to applicants.

## 3. Problem Being Addressed

Finding a job that matches an applicant's skills, qualifications, and work experience can be difficult. Applicants often spend time searching through different job postings and customizing their resumes for every application.

According to Resume Genius (2026), 41% of job seekers consider resume customization their most difficult resume-writing task.

Employers also experience difficulties reviewing numerous applications and identifying qualified candidates. Without a centralized platform for job matching, AI-assisted resume generation, and application tracking, the recruitment process can become time-consuming and less organized.

ResuMatch addresses these challenges by providing a centralized platform that helps applicants find suitable jobs, generate tailored resumes, and track their applications while allowing employers to manage recruitment more efficiently.

## 4. Project Objectives

The project aims to:

1. Develop a centralized platform where applicants can create and manage their professional profiles.
2. Recommend suitable job opportunities based on applicants' qualifications, skills, and experience.
3. Integrate the Gemini API to generate customized resumes based on selected job descriptions.
4. Provide employers with tools to publish job openings and manage applications.
5. Allow administrators to review and approve job postings before publication.
6. Provide an organized application tracking system for applicants and employers.
7. Demonstrate the application of Object-Oriented Programming concepts in developing a functional web-based system.

## 5. Target Users

**Applicants / Job Seekers**

- Create and manage professional profiles.
- Browse recommended job vacancies.
- Generate AI-assisted customized resumes.
- Submit job applications.
- Monitor application status and history.

**Employers / Recruiters**

- Create and manage job postings.
- Review applicants and their qualifications.
- View submitted resumes and applications.
- Manage applicant decisions.

**Administrators**

- Manage user access and roles.
- Review and approve job postings.
- Review skill suggestions and maintain platform organization.

## 6. Main Features

### 6.1 AI-Powered Resume Generation

Allows applicants to generate customized resumes using their saved profile information and selected job descriptions through the Gemini API.

### 6.2 Job Matching and Recommendations

Recommends available job opportunities based on the applicant's skills, educational background, qualifications, and work experience.

### 6.3 Applicant Profile Management

Allows applicants to maintain their personal and professional information, including education, work experience, achievements, certifications, soft skills, and hard skills.

### 6.4 Job Application Management

Enables applicants to submit applications and prevents duplicate applications for the same job posting.

### 6.5 Application Tracking

Allows applicants to view their application history and monitor the status of their submitted applications.

### 6.6 Employer Dashboard

Provides employers with tools to create job postings, review applicants, and manage application decisions.

### 6.7 Admin Job Posting Approval

Allows administrators to review and approve job postings before they become publicly available.

### 6.8 Admin Skill Review

Provides administrators with a dedicated interface for reviewing and managing skill suggestions.

### 6.9 Resume Preview and PDF Export

Allows applicants to preview their generated resumes and export them as PDF files.

## 7. Technologies Used

| Technology     | Purpose                                           |
| -------------- | ------------------------------------------------- |
| Java           | Main programming language and backend development |
| Spring Boot    | Backend application framework                     |
| MySQL          | Database management                               |
| HTML           | Webpage structure                                 |
| CSS            | Website styling and layout                        |
| JavaScript     | Frontend interactions                             |
| Gemini API     | AI-assisted resume generation                     |
| Git and GitHub | Version control and collaboration                 |

*Note: Update this section if your final implementation uses additional technologies or libraries.*

## 8. Team Members and Roles

| Member      | Assigned Responsibilities                                                                                                                                   |
| ----------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Tatlonghari | Database design, authentication, security, database configuration, access rules, and permissions                                                            |
| Fernandez   | Job matching, application management, duplicate application prevention, employer decisions, skill APIs, and Gemini API integration                          |
| Sulit       | Frontend development, login and registration interfaces, dashboards, job listings, admin skill-review screens, resume forms, resume preview, and PDF export |

## 9. OOP Concepts Demonstrated

The project applies Object-Oriented Programming concepts through its Java backend implementation.

**Encapsulation**

- Organizes data and methods within classes.
- Uses appropriate access modifiers to protect important information.
- Provides controlled access to object properties through methods.

**Abstraction**

- Separates essential system operations from their internal implementation.
- Uses services and interfaces to organize backend functionality.

**Inheritance**

- Allows classes to inherit shared properties and behaviors from parent classes, where applicable.

**Polymorphism**

- Allows methods or objects to perform different behaviors depending on their implementation.

**Classes and Objects**

- Represents system components such as applicants, employers, administrators, job postings, applications, and resumes through Java classes and objects.

*Note: The final documentation should reflect the OOP concepts actually implemented in your source code.*

## 10. Instructions for Running the Program

### Prerequisites

Before running ResuMatch, make sure you have the following installed:

- Java Development Kit (JDK)
- MySQL Server
- IntelliJ IDEA, Eclipse, or Visual Studio Code
- Git
- A web browser
- Gemini API key

### Setup Instructions

1. Clone the project repository from GitHub.
   ```bash
   git clone <repository-url>
   ```

2. Open the project in your preferred Java IDE.

3. Configure your MySQL database connection in the Spring Boot application configuration file.

4. Create the required database in MySQL.

5. Configure your Gemini API key using the application's environment configuration.

6. Install or resolve the required project dependencies.

7. Run the Spring Boot application.

8. Open your web browser and access the application's local development address.
   ```text
   http://localhost:8080
   ```

*Note: Adjust the database configuration, API key setup, and running commands according to the final project configuration.*

## 11. Sample Screenshots

The following screenshots will demonstrate the main interfaces and functionalities of ResuMatch:

- Login Page
- Registration Page
- Applicant Dashboard
- Applicant Profile Management
- Job Listings and Recommendations
- Job Matching Results
- Job Application Form
- Application History and Tracking
- Employer Dashboard
- Employer Applicant Management
- Admin Dashboard
- Admin Job Posting Approval
- Admin Skill Review
- AI-Powered Resume Generation
- Resume Preview
- Resume PDF Export

*Actual screenshots will be added after the completion and testing of the system.*

## 12. Known Limitations

The following are potential limitations to document during development and testing:

- Resume generation depends on the availability and proper configuration of the Gemini API.
- Job recommendations depend on the accuracy and completeness of applicant profile information and job requirements.
- The system requires an active database connection to store and retrieve information.
- AI-generated resume content may require manual review and correction by applicants.
- The accuracy of job matching depends on the information provided by applicants and employers.

## 13. Future Improvements

Possible improvements for future development include:

- Adding email notifications for application updates and employer decisions.
- Improving job matching through more advanced recommendation algorithms.
- Adding additional resume templates and customization options.
- Implementing stronger resume validation and content suggestions.
- Providing analytics and recruitment reports for employers.
- Improving mobile responsiveness and overall user experience.
- Adding more security measures and data protection features.

## 14. Project Contributors

**Development Team: ResuMatch**

| Contributor | Main Contribution                                                       |
| ----------- | ----------------------------------------------------------------------- |
| Tatlonghari | Database, Authentication, and Security                                  |
| Fernandez   | Backend Development, Job Matching, Applications, and Gemini API         |
| Sulit       | Frontend Development, Admin Interfaces, and Resume Generation Interface |

**Project Course:** OOP 101 – Object-Oriented Programming

**Project Type:** Web-Based Application

**Project Name:** ResuMatch

**RESUMATCH** is a web-based platform designed to make the job application process easier for applicants and employers. It allows applicants to create profiles containing their educational background, work experience, achievements, certifications, soft skills, and hard skills.

Using the information saved in their profiles, applicants can generate resumes tailored to the requirements of their chosen job positions through the Gemini API. The platform also recommends job vacancies based on their qualifications and skills.

Meanwhile, employers can post job openings and manage applications, while administrators review and approve job postings before they become available on the platform.

---

## **🤖 II. Features**

**1. AI-Powered Resume Generation**
- Generates customized resumes using the applicant's saved profile information.
- Uses the Gemini API to tailor resume content based on the selected job description.
- Highlights relevant skills, education, and work experience.
- Provides resume preview and PDF export.

**2. Job Matching and Recommendations**
- Recommends job vacancies based on the applicant's qualifications, skills, and experience.
- Displays matching scores to help applicants identify suitable opportunities.

**3. Applicant Profile Management**
- Allows applicants to manage their educational background and work experience.
- Stores achievements, certifications, soft skills, and hard skills.

**4. Job Application Management**
- Allows applicants to submit applications for available job positions.
- Prevents duplicate applications for the same job posting.
- Provides application history and status tracking.

**5. Employer Dashboard**
- Allows employers to create and manage job postings.
- Displays submitted applications and applicant information.
- Allows employers to review applicants and manage application decisions.

**6. Admin Management**
- Allows administrators to review and approve job postings.
- Provides skill-review screens for managing skill suggestions.
- Helps maintain organized job listings and platform content.

---

## **🏗 III. System Architecture**

### **🌐 Frontend**
- **Technologies**: HTML, CSS, JavaScript
- **Features**:
  - Responsive user interface.
  - Login and registration pages.
  - Applicant and employer dashboards.
  - Job listings and matching scores.
  - Application forms and tracking.
  - Admin job approval and skill-review screens.
  - Resume formatting, preview, and PDF export.

### **🖥 Backend**
- **Language**: Java
- **Framework**: Spring Boot
- **Features**:
  - User authentication and authorization.
  - Job matching and recommendation logic.
  - Job application processing.
  - Duplicate application prevention.
  - Employer application management.
  - Gemini API integration for AI-powered resume generation.
  - Skill suggestion and approval services.

### **🗄 Database**
- **Database Management System**: MySQL
- **Features**:
  - Stores user accounts and applicant profiles.
  - Manages educational background, skills, and work experience.
  - Stores job postings and applications.
  - Maintains application history and status.
  - Stores information for authentication and access control.

### **🔗 External API**
- **Gemini API**
  - Generates AI-assisted customized resumes.
  - Uses applicant profile information and selected job descriptions as input.

---

## **💻 IV. Applied OOP Concepts**

- **Encapsulation:**
  - Organizes related data and methods within Java classes.
  - Uses access modifiers to protect important information and control access to object properties.

- **Inheritance:**
  - Allows classes to inherit common properties and behaviors from parent classes, reducing code repetition where applicable.

- **Polymorphism:**
  - Allows methods to have different implementations depending on the objects or classes using them.

- **Abstraction:**
  - Separates essential operations from their internal implementation to make the system easier to organize and maintain.

- **Classes and Objects:**
  - Represents system components such as Users, Applicants, Employers, Administrators, Job Postings, Applications, and Resumes through Java classes and objects.

---

## **👥 V. Members**

- **Database, Authentication, and Security:**
  - Alison Tatlonghari
  - Database design and configuration.
  - User authentication and access control.
  - Database constraints and security.

- **Backend Developer:**
  - John Ulrich P. Fernandez
  - Job matching and recommendation logic.
  - Job application processing and duplicate prevention.
  - Employer decisions and skill APIs.
  - Gemini API integration.

- **Frontend Developer:**
  - Czarina Sulit
  - Frontend development and user interfaces.
  - Applicant and employer dashboards.
  - Admin skill-review screens.
  - Resume form, preview, and PDF export.

---

## **🎯 VI. Sustainable Development Goals (SDGs)**

**SDG 8 – Decent Work and Economic Growth**
- Promotes access to employment opportunities through job recommendations and AI-assisted resume generation.
- Helps employers identify suitable candidates and manage applications efficiently.

**SDG 9 – Industry, Innovation and Infrastructure**
- Integrates artificial intelligence into the recruitment process through the Gemini API.
- Demonstrates how modern technology can improve job searching and recruitment.

**SDG 10 – Reduced Inequalities**
- Provides applicants with a platform to showcase their skills, qualifications, and achievements.
- Supports fairer access to employment opportunities based on competencies and qualifications.

---

## **⚙️ VII. Technologies Used**

- **Java** – Main programming language.
- **Spring Boot** – Backend framework.
- **MySQL** – Database management.
- **HTML** – Webpage structure.
- **CSS** – Website styling.
- **JavaScript** – Frontend functionality.
- **Gemini API** – AI-powered resume generation.
- **Git and GitHub** – Version control and collaboration.

---

## **🚀 VIII. Future Improvements**

- Email notifications for application updates.
- Additional resume templates and customization options.
- Improved job recommendation algorithms.
- Recruitment analytics and reports for employers.
- Enhanced mobile responsiveness.
- Additional security and data protection features.
