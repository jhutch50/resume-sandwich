//let jsPDF = require('jspdf');
import {Component,  Directive, Input, OnInit, ViewChild, ElementRef} from "@angular/core";
import {FormControl, FormGroup} from "@angular/forms";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs/Rx";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import * as html2canvas from 'html2canvas';
import * as jsPDF from 'jspdf';
import { MatStepper } from '../../node_modules/@angular/material/stepper';
import { CdkStepperNext, StepperSelectionEvent } from '../../node_modules/@angular/cdk/stepper';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

    constructor(private http: Http) {

    }
    //Get URLs
    private baseUrl: string = 'http://localhost:8080';
    private getGeneralUrl: string = this.baseUrl + '/resume/resumeDisplay/v1';
    private workExperienceGetUrl: string = this.baseUrl + '/resume/workExperience/v1';
    private userInfoGetUrl: string = this.baseUrl + '/resume/userInfo/v1';    
    private activityGetUrl: string = this.baseUrl + '/resume/activity/v1';
    private educationGetUrl: string = this.baseUrl + '/resume/education/v1';
    private projectsGetUrl: string = this.baseUrl + '/resume/projects/v1';
    private skillsGetUrl: string = this.baseUrl + '/resume/skills/v1';
    private volunteerExperienceGetUrl: string = this.baseUrl + '/resume/volunteerExperience/v1';
    //Post URLs
    private userInfoPostUrl: string = this.baseUrl + '/resume/userInfo/v1/';
    private workExperiencePostUrl: string = this.baseUrl + '/resume/workExperience/v1/';
    private activityPostUrl: string = this.baseUrl + '/resume/activity/v1/';
    private educationPostUrl: string = this.baseUrl + '/resume/education/v1/';
    private projectsPostUrl: string = this.baseUrl + '/resume/projects/v1/';
    private skillsPostUrl: string = this.baseUrl + '/resume/skills/v1/';
    private volunteerExperiencePostUrl: string = this.baseUrl + '/resume/volunteerExperience/v1/';

    
    
    public submitted: boolean;


    //1. Declare Form Groups, Requests and currentWorkExperiences
    defineworkexperience: FormGroup;
    defineuserinfo: FormGroup;
    defineactivity: FormGroup;
    defineeducation: FormGroup;
    defineprojects: FormGroup;
    defineskills: FormGroup;
    definevolunteerexperience: FormGroup;

    //Requests
    workExperienceRequest: DefineWorkExperienceRequest;
    userInfoRequest: DefineUserInfoRequest;
    activityRequest: DefineActivityRequest;
    educationRequest: DefineEducationRequest;
    projectsRequest: DefineProjectsRequest;
    skillsRequest: DefineSkillsRequest;
    volunteerExperienceRequest: DefineVolunteerExperienceRequest;

    //Resume array from view
    resumes: Resume[];

    //currentWorkExperiences to make context specific 
    currentWorkExperienceResumeId: string;
    currentWorkExperienceCompany: string;
    currentWorkExperienceTitle: string;
    currentWorkExperienceStartDate: string;
    currentWorkExperienceEndDate: string;
    currentWorkExperienceCity: string;
    currentWorkExperienceState: string;
    currentWorkExperienceSkillsA: string;
    currentWorkExperienceSkillsB: string;
    currentWorkExperienceSkillsC: string;
    //currentUserInfos
    currentUserInfoResumeId: string;
    currentUserInfoFirstname: string;
    currentUserInfoLastname: string;
    currentUserInfoEmail: string;
    currentUserInfoPhone: string;
    currentUserInfoLinkedIn: string;
    currentUserInfoGitHub: string;
    //activity currents
    currentActivityResumeId: string;
    currentActivityClubName: string;
    currentActivityTitle: string;
    currentActivitySkillsA: string;
    currentActivitySkillsB: string;
    currentActivitySkillsC: string;
    currentActivityStartDate: string;
    currentActivityEndDate: string;
    //education currents
    currentEducationResumeId: string;
    currentEducationUniversityName: string;
    currentEducationDegree: string;
    currentEducationMajor: string;
    currentEducationConcentration: string;
    currentEducationCity: string;
    currentEducationState: string;
    currentEducationStartDate: string;
    currentEducationEndDate: string;
    currentEducationHonors: string;
    currentEducationGpa: string;

    //projects currents
    currentProjectsResumeId: string;
    currentProjectsProjectName: string;
    currentProjectsProjectRole: string;
    currentProjectsSkillsA: string;
    currentProjectsSkillsB: string;
    currentProjectsSkillsC: string;
    currentProjectsStartDate: string;
    currentProjectsEndDate: string;

    //skills currents
    currentSkillsResumeId: string;
    currentSkillsSkillName: string;

    //volunteerExperience currents
    currentVolunteerExperienceResumeId: string;
    currentVolunteerExperienceOrganization: string;
    currentVolunteerExperienceRole: string;
    currentVolunteerExperienceStartDate: string;
    currentVolunteerExperienceEndDate: string;
    currentVolunteerExperienceCity: string;
    currentVolunteerExperienceState: string;
    currentVolunteerExperienceSkillsA: string;
    currentVolunteerExperienceSkillsB: string;
    currentVolunteerExperienceSkillsC: string;

   
    
    //when the page first loads
    ngOnInit() {
      
        //2. Defined form groups that receive data from view
        this.defineworkexperience = new FormGroup({
            resumeId: new FormControl(''),
            company: new FormControl(''),
            title: new FormControl(''),
            startDate: new FormControl(''),
            endDate: new FormControl(''),
            city: new FormControl(''),
            state: new FormControl(''),
            skillsA: new FormControl(''),
            skillsB: new FormControl(''),
            skillsC: new FormControl('')
        });
        this.defineuserinfo = new FormGroup({
            resumeId: new FormControl(''),            
            firstname: new FormControl(''),
            lastname: new FormControl(''),
            email: new FormControl(''),
            phone: new FormControl(''),
            linkedin: new FormControl(''),
            github: new FormControl('')
        });
        this.defineeducation = new FormGroup({
            resumeId: new FormControl(''),
            universityName: new FormControl(''),
            degree: new FormControl(''),
            major: new FormControl(''),
            concentration: new FormControl(''),
            city: new FormControl(''),
            state: new FormControl(''),
            startDate: new FormControl(''),
            endDate: new FormControl(''),
            honors: new FormControl(''),
            gpa: new FormControl('')
        });
        this.defineprojects = new FormGroup({
            resumeId: new FormControl(''),
            projectName: new FormControl(''),
            projectRole: new FormControl(''),
            skillsA: new FormControl(''),
            skillsB: new FormControl(''),
            skillsC: new FormControl(''),
            startDate: new FormControl(''),
            endDate: new FormControl('')

        });
        this.defineskills = new FormGroup({
            resumeId: new FormControl(''),
            skillName: new FormControl('')

        });
        this.definevolunteerexperience = new FormGroup({
            resumeId: new FormControl(''),
            organization: new FormControl(''),
            role: new FormControl(''),
            startDate: new FormControl(''),
            endDate: new FormControl(''),
            city: new FormControl(''),
            state: new FormControl(''),
            skillsA: new FormControl(''),
            skillsB: new FormControl(''),
            skillsC: new FormControl('')

        });
        this.defineactivity = new FormGroup({
            resumeId: new FormControl(''),
            clubName: new FormControl(''),
            title: new FormControl(''),
            skillsA: new FormControl(''),
            skillsB: new FormControl(''),
            skillsC: new FormControl(''),
            startDate: new FormControl(''),
            endDate: new FormControl('')
        });


        //3. Set constants for form groups based on ValueChanges$

        const defineuserinfoValueChanges$ = this.defineuserinfo.valueChanges;
        const defineeducationValueChanges$ = this.defineeducation.valueChanges;
        const defineskillsValueChanges$ = this.defineskills.valueChanges;
        const defineprojectsValueChanges$ = this.defineprojects.valueChanges;
        const defineworkexperienceValueChanges$ = this.defineworkexperience.valueChanges;
        const definevolunteerexperienceValueChanges$ = this.definevolunteerexperience.valueChanges;
        const defineactivityValueChanges$ = this.defineactivity.valueChanges;
        
       //4. subscribe the values from the ValueChanges to the currentWorkExperience values
        defineworkexperienceValueChanges$.subscribe(valChange => {
            this.currentWorkExperienceResumeId = valChange.resumeId;
            this.currentWorkExperienceCompany = valChange.company;
            this.currentWorkExperienceTitle = valChange.title;
            this.currentWorkExperienceStartDate = valChange.startDate;
            this.currentWorkExperienceEndDate = valChange.endDate;
            this.currentWorkExperienceCity = valChange.city;
            this.currentWorkExperienceState = valChange.state;
            this.currentWorkExperienceSkillsA = valChange.skillsA;
            this.currentWorkExperienceSkillsB = valChange.skillsB;
            this.currentWorkExperienceSkillsC = valChange.skillsC;
        });
        defineuserinfoValueChanges$.subscribe(valChange => {
                this.currentUserInfoResumeId = valChange.resumeId;
                this.currentUserInfoFirstname = valChange.firstname;
                this.currentUserInfoLastname = valChange.lastname;
                this.currentUserInfoEmail = valChange.email;
                this.currentUserInfoPhone = valChange.phone;
                this.currentUserInfoLinkedIn = valChange.linkedin;
                this.currentUserInfoGitHub = valChange.github;
        });
        defineactivityValueChanges$.subscribe(valChange => {
            this.currentActivityResumeId = valChange.resumeId;
            this.currentActivityClubName = valChange.clubName;
            this.currentActivityTitle = valChange.title;
            this.currentActivitySkillsA = valChange.skillsA;
            this.currentActivitySkillsB = valChange.skillsB;
            this.currentActivitySkillsC = valChange.skillsC;
            this.currentActivityStartDate = valChange.startDate;
            this.currentActivityEndDate = valChange.endDate;

        });
        defineeducationValueChanges$.subscribe(valChange => {
            this.currentEducationResumeId = valChange.resumeId;
            this.currentEducationUniversityName = valChange.universityName;
            this.currentEducationDegree = valChange.degree;
            this.currentEducationMajor = valChange.major;
            this.currentEducationConcentration = valChange.concentration;
            this.currentEducationCity = valChange.city;
            this.currentEducationState = valChange.state;
            this.currentEducationStartDate = valChange.startDate;
            this.currentEducationEndDate = valChange.endDate;
            this.currentEducationHonors = valChange.honors;
            this.currentEducationGpa = valChange.gpa;

        });
        defineskillsValueChanges$.subscribe(valChange => {
            this.currentSkillsResumeId = valChange.resumeId;
            this.currentSkillsSkillName = valChange.skillName;

        });
        defineprojectsValueChanges$.subscribe(valChange => {
            this.currentProjectsResumeId = valChange.resumeId;
            this.currentProjectsProjectName = valChange.projectName;
            this.currentProjectsProjectRole = valChange.projectRole;
            this.currentProjectsSkillsA = valChange.skillsA;
            this.currentProjectsSkillsB = valChange.skillsB;
            this.currentProjectsSkillsC = valChange.skillsC;
            this.currentProjectsStartDate = valChange.startDate;
            this.currentProjectsEndDate = valChange.endDate;

        });

        definevolunteerexperienceValueChanges$.subscribe(valChange => {
            this.currentVolunteerExperienceResumeId = valChange.resumeId;
            this.currentVolunteerExperienceOrganization = valChange.organization;
            this.currentVolunteerExperienceRole = valChange.role;
            this.currentVolunteerExperienceStartDate = valChange.startDate;
            this.currentVolunteerExperienceEndDate = valChange.endDate;
            this.currentVolunteerExperienceCity = valChange.city;
            this.currentVolunteerExperienceState = valChange.state;
            this.currentVolunteerExperienceSkillsA = valChange.skillsA;
            this.currentVolunteerExperienceSkillsB = valChange.skillsB;
            this.currentVolunteerExperienceSkillsC = valChange.skillsC;

        });

        
        
        this.getAll()
            .subscribe(
            resumes => this.resumes = resumes,
            err => {
                console.log(err);
            });
    }

    //onSubmit collects data when the submit button is pressed
    //note that at the moment it just passes Define Work Experience.
    //figure out how to reload page on submit for resume. In JS it is just .redirect to servlet
    workExperienceOnSubmit({value, valid}: { value: DefineWorkExperienceRequest, valid: boolean }) {
        this.getAll()
            .subscribe(
            resumes => this.resumes = resumes,
            err => {
                console.log(err);
            });
    }


    getAll():Observable<Resume[]> {
        return this.http
            .get(this.getGeneralUrl + '?resumeNumber=' + this.currentWorkExperienceResumeId)
            .map(this.mapResume);
    }
    //8. Take the Define classes and store them in the requests and store those in the creates
    defineWorkExperience(value: string) {

        this.workExperienceRequest = new DefineWorkExperienceRequest(value, 
        this.currentWorkExperienceCompany,
        this.currentWorkExperienceTitle,
        this.currentWorkExperienceStartDate,
        this.currentWorkExperienceEndDate,
        this.currentWorkExperienceCity,
        this.currentWorkExperienceState,
        this.currentWorkExperienceSkillsA,
        this.currentWorkExperienceSkillsB,
        this.currentWorkExperienceSkillsC
        );
        
        if(this.currentWorkExperienceCompany!=''){
            if(this.currentWorkExperienceCompany!=null){
            this.postModule(this.workExperienceRequest, this.workExperiencePostUrl);
                }
        }
        
    }
    defineActivity(value: string) {

            this.activityRequest = new DefineActivityRequest(value, 
            this.currentActivityClubName,
            this.currentActivityTitle,
            this.currentActivitySkillsA,
            this.currentActivitySkillsB,
            this.currentActivitySkillsC,
            this.currentActivityStartDate,
            this.currentActivityEndDate
            );
        //condition for post
        
        if(this.currentActivityClubName!=''){
            if(this.currentActivityClubName!=null){
            this.postFinalResume(this.activityRequest, this.activityPostUrl);
                }
        }
        window.location.reload();
    }
    defineEducation(value: string) {

            this.educationRequest = new DefineEducationRequest(value, 
            this.currentEducationUniversityName,
            this.currentEducationDegree,
            this.currentEducationMajor,
            this.currentEducationConcentration,
            this.currentEducationCity,
            this.currentEducationState,
            this.currentEducationStartDate,
            this.currentEducationEndDate,
            this.currentEducationHonors,
            this.currentEducationGpa

        );
        
        //condition for post
        
        if(this.currentEducationUniversityName!=''){
             if(this.currentEducationUniversityName!=null){
            this.postModule(this.educationRequest, this.educationPostUrl);
                 }
        }        
    }
    defineProjects(value: string) {

        this.projectsRequest = new DefineProjectsRequest(value, 
        this.currentProjectsProjectName,
        this.currentProjectsProjectRole,
        this.currentProjectsSkillsA,
        this.currentProjectsSkillsB,
        this.currentProjectsSkillsC,
        this.currentProjectsStartDate,
        this.currentProjectsEndDate
        );
        //condition for post 
               
        if(this.currentProjectsProjectName!=''){
             if(this.currentProjectsProjectName!=null){
            this.postModule(this.projectsRequest, this.projectsPostUrl);
                 }
        }  


        
    }
    defineSkills(value: string) {

        this.skillsRequest = new DefineSkillsRequest(value, 
        this.currentSkillsSkillName
            );
        //condition for post
        
        if(this.currentSkillsSkillName!=''){
            if(this.currentSkillsSkillName!=null){
            this.postModule(this.skillsRequest, this.skillsPostUrl);
                }
        }  

        
    }
   defineVolunteerExperience(value: string) {

        this.volunteerExperienceRequest = new DefineVolunteerExperienceRequest(value, 
        this.currentVolunteerExperienceOrganization,
        this.currentVolunteerExperienceRole,
        this.currentVolunteerExperienceStartDate,
        this.currentVolunteerExperienceEndDate,
        this.currentVolunteerExperienceCity,
        this.currentVolunteerExperienceState,
        this.currentVolunteerExperienceSkillsA,
        this.currentVolunteerExperienceSkillsB,
        this.currentVolunteerExperienceSkillsC
        );
        //condition for post
        
        if(this.currentVolunteerExperienceOrganization!=''){
            if(this.currentVolunteerExperienceOrganization!=null){
            this.postModule(this.volunteerExperienceRequest, this.volunteerExperiencePostUrl);
                }
        }          
    }
    
    
    defineUserInfo(value: string) {

        this.userInfoRequest = new DefineUserInfoRequest(value, 
        this.currentUserInfoFirstname,
        this.currentUserInfoLastname,
        this.currentUserInfoEmail,
        this.currentUserInfoPhone,
        this.currentUserInfoLinkedIn,
        this.currentUserInfoGitHub
        );

        
        
        if(this.currentUserInfoFirstname!=''){
            if(this.currentUserInfoFirstname!=null){
            this.postModule(this.userInfoRequest, this.userInfoPostUrl);
                }
        }
        
        
    }
    //7. Make the creat universal as this will always post based on the different classes

    postModule(body:Object, postUrl: string) {
        //Takes the object passed
        let bodyString = JSON.stringify(body);
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        //POSTs the object using a subsribe
        this.http.post(postUrl, bodyString, options)
            .subscribe(res => console.log(res));
    } 

    postFinalResume(body:Object, postUrl: string) {
        //Takes the object passed
        let bodyString = JSON.stringify(body);
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        //POSTs the object using a subsribe
        this.http.post(postUrl, bodyString, options)
            .subscribe(res => console.log(res));
        window.location.reload();
    }

    mapResume(response:Response):Resume[] {
        return response.json().content;
    }

    //function for the pdf export from html2pdf
    download(): void {
       var resumefit = document.getElementById('doctest');
        resumefit.style.width="800px";
        var pageHeight = resumefit.offsetHeight;
        var eachPageHeight = 300;
        var position = 0;
        
        html2canvas(resumefit, { allowTaint: true, scale:3}).then(
       function(canvas){
           var imgHeight = canvas.height *  (200-12.5) /canvas.width;
           var heightLeft = imgHeight;
           var img = canvas.toDataURL("image/jpeg", 1.0);
           let pdf = new jsPDF('p', 'mm', 'letter');
           pdf.addImage(img,'PNG', 12.5, (5+position), 200, imgHeight-10);
           heightLeft-=eachPageHeight;
           
           while(heightLeft >= 0){
               position = heightLeft - imgHeight;
               pdf.addPage();
               pdf.addImage(img,'PNG', 12.5, (position+25), 200, imgHeight-10);
               heightLeft-=eachPageHeight;
               }
           
           
           pdf.save("Resume.pdf");

    })};

    


}



export interface Resume {
    id: string,
    resumeNumber: string,
    userInfoEntityList: any[],
    educationEntityList: any[],
    skillsEntityList: any[],
    projectsEntityList: any[],
    workExperienceEntityList: any[],
    collegeEngagementEntityList: any[],
    volunteerExperienceEntityList: any[]
}
//6. Define classes

export class DefineWorkExperienceRequest {
    resumeId: string;
    company: string;
    title: string;
    startDate: string;
    endDate: string;
    city: string;
    state: string;
    skillsA: string;
    skillsB: string;
    skillsC: string;

    constructor(
        resumeId: string,
        company: string,
        title: string,
        startDate: string,
        endDate: string,
        city: string,
        state: string,
        skillsA: string,
        skillsB: string,
        skillsC: string
        
    ) {
        this.resumeId = resumeId;
        this.company = company;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.city = city;
        this.state = state;
        this.skillsA = skillsA;
        this.skillsB = skillsB;
        this.skillsC = skillsC;
    }
}

export class DefineUserInfoRequest {

        resumeId: string;
        firstname: string;
        lastname: string;
        email: string;
        phone: string;
        linkedIn: string;
        gitHub: string;
    
    constructor(
        resumeId: string,
        firstname: string,
        lastname: string,
        email: string,
        phone: string,
        linkedIn: string,
        gitHub: string
        
    ) {
        this.resumeId = resumeId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.linkedIn = linkedIn;
        this.gitHub = gitHub;
    }
}

export class DefineActivityRequest {

        resumeId: string;
        clubName: string;
        title: string;
        skillsA: string;
        skillsB: string;
        skillsC: string;
        startDate: string;
        endDate: string;

   
    constructor(
        resumeId: string,
        clubName: string,
        title: string,
        skillsA: string,
        skillsB: string,
        skillsC: string,
        startDate: string,
        endDate: string

      
    ) {
        this.resumeId = resumeId;
        this.clubName = clubName;
        this.title = title;
        this.skillsA = skillsA;
        this.skillsB = skillsB;
        this.skillsC = skillsC;
        this.startDate = startDate;
        this.endDate = endDate;


    }
}
export class DefineEducationRequest {

        resumeId: string;
        universityName: string;
        degree: string;
        major: string;
        concentration: string;
        city: string;
        state: string;
        startDate: string;
        endDate: string;
        honors: string;
        gpa: string;

   
    constructor(
        resumeId: string,
        universityName: string,
        degree: string,
        major: string,
        concentration: string,
        city: string,
        state: string,
        startDate: string,
        endDate: string,
        honors: string,
        gpa: string

      
    ) {
        this.resumeId = resumeId;
        this.universityName = universityName;
        this.degree = degree;
        this.major = major;
        this.concentration = concentration;
        this.city = city;
        this.state = state;
        this.startDate = startDate;
        this.endDate = endDate;
        this.honors = honors;
        this.gpa = gpa;

    }
}
export class DefineProjectsRequest {

        resumeId: string;
        projectName: string;
        projectRole: string;
        skillsA: string;
        skillsB: string;
        skillsC: string;
        startDate: string;
        endDate: string;

    constructor(
        resumeId: string,
        projectName: string,
        projectRole: string,
        skillsA: string,
        skillsB: string,
        skillsC: string,
        startDate: string,
        endDate: string

      
    ) {
        this.resumeId = resumeId;
        this.projectName = projectName;
        this.projectRole = projectRole;
        this.skillsA = skillsA;
        this.skillsB = skillsB;
        this.skillsC = skillsC;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
export class DefineSkillsRequest {

        resumeId: string;
        skillName: string;

   
    constructor(
        resumeId: string,
        skillName: string
        
      
    ) {
        this.resumeId = resumeId;
        this.skillName = skillName;


    }
}
export class DefineVolunteerExperienceRequest {

        resumeId: string;
        organization: string;
        role: string;
        startDate: string;
        endDate: string;
        city: string;
        state: string;
        skillsA: string;
        skillsB: string;
        skillsC: string;

   
    constructor(
        resumeId: string,
        organization: string,
        role: string,
        startDate: string,
        endDate: string,
        city: string,
        state: string,
        skillsA: string,
        skillsB: string,
        skillsC: string

      
    ) {
        this.resumeId = resumeId;
        this.organization = organization;
        this.role = role;
        this.startDate = startDate;
        this.endDate = endDate;
        this.city = city;
        this.state = state;
        this.skillsA = skillsA;
        this.skillsB = skillsB;
        this.skillsC = skillsC;

    }
}

