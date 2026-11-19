
# **RESUMATCH**
### AI-Powered Job Matching and Resume Generation Platform

---

## **📄📎 I. Project Overview**

**RESUMATCH** is a web-based platform designed to simplify the job application and recruitment process by connecting job seekers with suitable employment opportunities. It allows applicants to create profiles containing their educational background, work experience, achievements, certifications, soft skills, and hard skills.

Using the information stored in their profiles, applicants can generate customized resumes tailored to specific job positions through the Gemini API. The system also recommends job vacancies based on their qualifications and skills.

Additionally, employers can publish job openings and manage applications, while administrators review and approve job postings before they become available to applicants.

---

## **⚠️ II. Problem Being Addressed**

Finding a job that matches an applicant's skills, qualifications, and work experience can be difficult. Applicants often spend time searching through different job postings and customizing their resumes for every application.

According to Resume Genius (2026), 41% of job seekers consider resume customization their most difficult resume-writing task.

Employers also experience difficulties reviewing numerous applications and identifying qualified candidates. Without a centralized platform for job matching, AI-assisted resume generation, and application tracking, the recruitment process can become time-consuming and less organized.

ResuMatch addresses these challenges by providing a centralized platform that helps applicants find suitable jobs, generate tailored resumes, and track their applications while allowing employers to manage recruitment more efficiently.

---

## **🎯 III. Project Objectives**

The project aims to:

1. Develop a centralized platform where applicants can create and manage their professional profiles.
2. Recommend suitable job opportunities based on applicants' qualifications, skills, and experience.
3. Integrate the Gemini API to generate customized resumes based on selected job descriptions.
4. Provide employers with tools to publish job openings and manage applications.
5. Allow administrators to review and approve job postings before publication.
6. Provide an organized application tracking system for applicants and employers.
7. Demonstrate the application of Object-Oriented Programming concepts in developing a functional web-based system.

---

## **👥 IV. Target Users**

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

---

## **🤖 V. System Features**

**AI-Powered Resume Generation**
- Generates customized resumes using the applicant's saved profile information.
- Uses the Gemini API to tailor resume content based on the selected job description.
- Highlights relevant skills, education, and work experience.
- Provides resume preview and PDF export.

**Job Matching and Recommendations**
- Recommends job vacancies based on the applicant's qualifications, skills, and experience.
- Displays matching scores to help applicants identify suitable opportunities.

**Applicant Profile Management**
- Allows applicants to manage their educational background and work experience.
- Stores achievements, certifications, soft skills, and hard skills.

**Job Application Management**
- Allows applicants to submit applications for available job positions.
- Prevents duplicate applications for the same job posting.
- Provides application history and status tracking.

**Employer Dashboard**
- Allows employers to create and manage job postings.
- Displays submitted applications and applicant information.
- Allows employers to review applicants and manage application decisions.

**Admin Management**
- Allows administrators to review and approve job postings.
- Provides skill-review screens for managing skill suggestions.
- Helps maintain organized job listings and platform content.

---

## **🏗 VI. System Architecture**

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
- **Gemini API**:
  - Generates AI-assisted customized resumes.
  - Uses applicant profile information and selected job descriptions as input.

---

## **⚙️ VII. Technologies Used**

| Technology | Purpose |
|---|---|
| Java | Main programming language and backend development |
| Spring Boot | Backend application framework |
| MySQL | Database management |
| HTML | Webpage structure |
| CSS | Website styling and layout |
| JavaScript | Frontend interactions |
| Gemini API | AI-assisted resume generation |
| Git and GitHub | Version control and collaboration |

---

## **💻 VIII. Applied OOP Concepts**

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

---

## **🚀 IX. Instructions for Running the Program**

### **Prerequisites**
Before running ResuMatch, make sure you have the following installed:

- Java Development Kit (JDK)
- MySQL Server
- IntelliJ IDEA, Eclipse, or Visual Studio Code
- Git
- A web browser
- Gemini API key

### **Setup Instructions**

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

---

## **📸 X. Sample Screenshots**

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

---

## **⚠️ XI. Known Limitations**

The following are potential limitations to document during development and testing:

- Resume generation depends on the availability and proper configuration of the Gemini API.
- Job recommendations depend on the accuracy and completeness of applicant profile information and job requirements.
- The system requires an active database connection to store and retrieve information.
- AI-generated resume content may require manual review and correction by applicants.
- The accuracy of job matching depends on the information provided by applicants and employers.

---

## **🔮 XII. Future Improvements**

- Adding email notifications for application updates and employer decisions.
- Improving job matching through more advanced recommendation algorithms.
- Adding additional resume templates and customization options.
- Implementing stronger resume validation and content suggestions.
- Providing analytics and recruitment reports for employers.
- Improving mobile responsiveness and overall user experience.
- Adding more security measures and data protection features.

---

## **📌 XIII. Project Contributors**

**Development Team: ResuMatch**

| Contributor | Main Contribution |
|---|---|
| Tatlonghari | Database, Authentication, and Security |
| Fernandez | Backend Development, Job Matching, Applications, and Gemini API |
| Sulit | Frontend Development, Admin Interfaces, and Resume Generation Interface |

---

## **📚 XIV. Project Information**

- **Project Name**: ResuMatch
- **Project Course**: OOP 101 – Object-Oriented Programming
- **Project Type**: Web-Based Application
- **Development Team**: ResuMatch
