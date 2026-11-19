
# **RESUMATCH**
### AI-Powered Job Matching and Resume Generation Platform

---

## **📄📎 I. Overview**

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
