const gridContainer = document.querySelector(".grid-container");
let cards = [];
let termJson, answerJson, finalJson;
let firstCard, secondCard;
let lockBoard = false;
let score = 0;
let pairs = 0;

document.querySelector(".score").textContent = score;

//use the fetch api to get the data from the json file
fetch('http://localhost:8080/terms')
    .then(response => response.json())
    .then(json => {
        termJson = json;
    })
fetch('http://localhost:8080/answers')
    .then(response => response.json())
    .then(json => {
        answerJson = json;
        finalJson = termJson.concat(answerJson);
        console.log(finalJson);
        cards = finalJson;
        pairs = answerJson.length;
        shuffleCards();
        generateCards();
    })


// Randomizes the array so that cards are put in random order
function shuffleCards() {
    let currentIndex = cards.length, randomIndex, temporaryValue;
    while (currentIndex !== 0) {
        randomIndex = Math.floor(Math.random() * currentIndex);
        currentIndex -= 1;
        temporaryValue = cards[currentIndex];
        cards[currentIndex] = cards[randomIndex];
        cards[randomIndex] = temporaryValue;
    }
}

// Creates the cards in html for the user to see
function generateCards() {
    for (let card of cards) {
        const cardElement = document.createElement("div");
        cardElement.classList.add("card");
        cardElement.setAttribute("data-id", card.id);
        cardElement.innerHTML = '<div class="front"> <p class="card-text">' + card.text +'</p></div> <div class="back"></div>';
        gridContainer.appendChild(cardElement);
        cardElement.addEventListener("click", flipCard);
    }
}

// Flips the card over so the user can see the term/definition
function flipCard() {
    if (lockBoard) return;
    if (this == firstCard) return;

    this.classList.add("flipped"); // also add the flipped class

    if (!firstCard) {
        firstCard = this;
        return;
    }

    secondCard = this;
    console.log(firstCard);
    if (firstCard.dataset.id === secondCard.dataset.id) {
        score++;
        if (score === pairs) {
            document.getElementById("win-screen").style = 'transform: translateX(0%);';
        }
    }
    document.querySelector(".score").textContent = score;
    lockBoard = true;

    checkForMatch();
}

// checks if two cards are the correct pair
function checkForMatch() {
    let isMatch = firstCard.dataset.id === secondCard.dataset.id;

    isMatch ? disabledCards() : unFlipCards();
}

// Once cards are both flipped the cards will stay like that and will no longer 
// be able to be flipped back
function disabledCards() {
    firstCard.removeEventListener("click", flipCard);
    secondCard.removeEventListener("click", flipCard);

    resetBoard();
}

// Unflips the cards that are flipped once two non pairs are flipped
function unFlipCards() {
    setTimeout(() => {
        firstCard.classList.remove("flipped");
        secondCard.classList.remove("flipped");
        resetBoard();
    }, 1000);
}

// resets the board, setting null to the cards chosen
function resetBoard() {
    firstCard = null;
    secondCard = null;
    lockBoard = false;
}

// restart button that restarts all the cards
function restart() {
    resetBoard();
    shuffleCards();
    score = 0;
    document.querySelector(".score").textContent = score;
    gridContainer.innerHTML = "";
    generateCards();
    document.getElementById("win-screen").style = 'transform: translateX(300%);';
}

// splash screen stuff
var splashScreen = document.querySelector('.splash');
splashScreen.addEventListener('click',()=>{
    splashScreen.computedStyleMap.opacity = 0;
    setTimeout(()=>{
        splashScreen.classList.add('hidden')
    },610)
})
