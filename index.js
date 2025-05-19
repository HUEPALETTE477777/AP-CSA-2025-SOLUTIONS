let portfolio_works = [ 
	{source: "images/Guan_Ivan_BanksyStencil.jpg", title: "banksy stencil", description: "BANKSY STENCIL PHONK XD", application: "Photoshop"},
    {source: "images/Guan_Ivan_WoodBrand.jpg", title: "wood brand", description: "phonk harding wood", application: "Photoshop"},
    {source: "images/Guan_Ivan_PolaroidCollage.jpg", title: "colleen collage", description: "mr beast inspired", application: "Photoshop"},
    {source: "images/Guan_Ivan_PopArt.jpg", title: "pop that art", description: "kesha inspired", application: "Photoshop"},
    {source: "images/Guan_Ivan_PostCards.jpg", title: "post cards", description: "incorporated countries", application: "Google Slides"},
    {source: "images/Guan_Ivan_Map.jpg", title: "india map", description: "country map", application: "Photoshop + Google Slides"},
    {source: "images/Guan_Ivan_GraffitiWall.jpg", title: "graffiti wall", description: "ishowspeed graffiti", application: "Photoshop"},
    {source: "images/Guan_Ivan_FoodTruck.jpg", title: "food truck", description: "food truck template", application: "Photoshop"},
    {source: "images/Guan_Ivan_FoodTruck_Menu.jpg", title: "food truck menu", description: "custom food truck menu", application: "Photoshop"},
    {source: "images/Guan_Ivan_Composite.jpg", title: "composite gym bro", description: "random jacked dude at mcdonalds", application: "Photoshop"},
    {source: "images/Guan_Ivan_ClientProject.jpg", title: "klient projekt", description: "made for dmhs as a client", application: "Photoshop"}
];

let main_button = document.getElementById("main-btn");

let portfolioWorksContainer = document.getElementById("portfolio-works-container");
let portfolioPaginationContainer = document.getElementById("portfolio-pagination-container");

let aboutMeContainer = document.getElementById("about-me-container");

let viewContainer = document.getElementById("view-container");

let test = document.getElementById("test");

let isWorksOpen = false;
let isWorkOpen = false;

// ----------------------------------------------------------------------//
// JQUERY NOW

$(document).ready(function() {
	$(main_button).click(function() {
        mainButtonNavigation();
	});
    
})

function mainButtonNavigation() {
    if (!isWorkOpen) {
        if (!isWorksOpen) {
            showMainContainers();
            DisplayWorks();
            constructAboutMe();
            isWorksOpen = true;
            main_button.textContent = "click to close content";
        } else {
            main_button.textContent = "click to view content";
            hideMainContainers();
            hideWorkContainer();
            isWorksOpen = false;
        }
    }

    if (isWorkOpen) {
        isWorkOpen = false;
        hideWorkContainer();
        showMainContainers();
        main_button.textContent = "click to close content";
    }
}

// JQUERY SEGMENTATION ENDS HERE, ALL FUNCTIONS ABSTRACTED ARE BELOW
// ---------------------------------------------------------------------- //

// PAGINATION VARIABLES
let currentPage = 1;
let pageAmount = 3;
let portfolioWorksLen = portfolio_works.length;
let pageResults = [];


function DisplayWorks() {
    portfolioWorksContainer.innerHTML = "";
    $(portfolioWorksContainer).addClass("portfolio-works-container");
    
    let start = (currentPage - 1) * pageAmount;
    let end = (currentPage * pageAmount);
    
    pagedResult = portfolio_works.slice(start, end);
    
	pagedResult.forEach((work) => {
		let portfolio_work_div = constructWork(work);

        $(portfolio_work_div).click(function() {
            main_button.textContent = "go back";
            hideMainContainers();
            isWorkOpen = true;
            DisplayWork(portfolio_work_div);
        });
        
		portfolioWorksContainer.appendChild(portfolio_work_div);
	})
    
    updatePagination();
}

function DisplayWork(target) {
    let img = document.createElement("img");
    img.src = $(target).find('img').attr("src");

    let title = document.createElement("h1");
    title.textContent = "TITLE: " + $(target).find('h1').text();

    let download = document.createElement("a");
    download.href = $(target).find('img').attr("src");
    download.textContent = "view in browser";

    $(viewContainer).append(img, title, download);
}


function updatePagination() {
    portfolioPaginationContainer.innerHTML = "";
    $(portfolioPaginationContainer).addClass("portfolio-pagination-container");
    
    let total_pages = Math.ceil(portfolioWorksLen / pageAmount);
    
    for (let i = 1; i <= total_pages; i++) {
        let pagination_btn = CreateButton();
        pagination_btn.textContent = i;
        $(pagination_btn).addClass("portfolio-pagination-button");
        
        if (i == currentPage) { $(pagination_btn).addClass("portfolio-pagination-button-active"); }

        $(pagination_btn).click(function() {
            currentPage = pagination_btn.textContent;
            DisplayWorks();
        })
            
        portfolioPaginationContainer.appendChild(pagination_btn);
    }
}

function constructWork(work) {
    let portfolio_work_div = CreateDiv();
	$(portfolio_work_div).addClass("portfolio-work-div")

	let portfolio_image = ImageRetrieval(work.source);
	$(portfolio_image).addClass("portfolio-image");

	let portfolio_title = CreateH1(work.title);
	$(portfolio_title).addClass("portfolio-title");

	let portfolio_description = CreateP(work.description);
	$(portfolio_description).addClass("portfolio-description");

    let portfolio_application = CreateP(work.application);
	$(portfolio_application).addClass("portfolio-application");

    $(portfolio_work_div).append(portfolio_image, portfolio_title, portfolio_description, portfolio_application);

    return portfolio_work_div;
}

function constructAboutMe() {
    aboutMeContainer.innerHTML = "";
    aboutMeContainer.classList.add("about-me-container");
    
    let greeting = CreateH1("hello i am ivan guan sigma");

    let paragraph = CreateP("i did this portfolio assignment and this is the about me. something about me is that i wish to be unemployed");
    
    $(aboutMeContainer).append(greeting, paragraph);
}

// HELPER FUNCTIONS, ALLAHU AKBAR
//------------------------------------------------------//
function ImageRetrieval(source) {
	let image = document.createElement("img");
	image.src = source;
	return image;
}

function CreateDiv() {
	let div = document.createElement("div");
	return div;
}

function CreateH1(text) {
	let h1 = document.createElement("h1");
	h1.textContent = text;
	return h1;
}

function CreateP(text) {
	let p = document.createElement("p");
	p.textContent = text;
	return p;
}

function CreateButton() {
    let btn = document.createElement("button");
    return btn;
}

function hideMainContainers() {
    $(aboutMeContainer).hide();
    $(portfolioWorksContainer).hide();
    $(portfolioPaginationContainer).hide();
}

function showMainContainers() {
    $(aboutMeContainer).show();
    $(portfolioWorksContainer).show();
    $(portfolioPaginationContainer).show();
    viewContainer.innerHTML = "";
}

function hideWorkContainer() {
    viewContainer.innerHTML = "";
}

// HELPER FUNCTIONS END HERE
//------------------------------------------------------------------//



