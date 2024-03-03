// Observer to check whether an element is on the screen and if so, adds show class
// If not, removes show class
const observer = new IntersectionObserver((entries) => {
    entries.forEach((entry) => {
        console.log(entry)
        if (entry.isIntersecting) {
            entry.target.classList.add('show');
        } else {
            entry.target.classList.remove('show');
        }
    });
});

// Gathers elements with class hidden and sends them through the observer
const hiddenElements = document.querySelectorAll('.hidden');
hiddenElements.forEach((el) => observer.observe(el));


let count = 0;

function saveSetItem() {
    // Get input values from text fields
    var term = document.getElementById("termInput").value;
    var definition = document.getElementById("definitionInput").value;

    // Create an object with term and definition fields
    console.log(definition);

    var setItem = {
        term: term,
        definition: definition
    };

    // Display the object on the website
    if (setItem.term != "" && setItem.def != "") {
        console.log(count);
        count++;
        document.getElementById("numberOfItems").innerText = count;
        createBox(setItem);

        document.getElementById("termInput").value = "";
        document.getElementById("definitionInput").value = "";
        var curTerm = {
            answer_id : count,
            id: count,
            text: setItem.term
        }

        var curAnswer = {
            term_id : count,
            id: count,
            text: setItem.definition
        }
        var jsonString = JSON.stringify(setItem);
        console.log(jsonString);
        console.log(document.getElementById("numberOfItems").innerHTML);
        fetch('http://localhost:8080/terms', {
            method: "POST",
            body: JSON.stringify(curTerm),
            headers: {
                "Content-type": "application/json; charset=UTF-8"
            }
        })
        fetch('http://localhost:8080/answers', {
            method: "POST",
            body: JSON.stringify(curAnswer),
            headers: {
                "Content-type": "application/json; charset=UTF-8"
            }
        })
    }
}

function createBox(setItem) {
    var boxContainer = document.getElementById("boxContainer");
    var newBox = document.createElement("div");
    newBox.className = "row";
    newBox.innerHTML = '<div class = "boxItem" style="text-align: right;">' + setItem.term + "</div>" + '<div class = "boxItem">' + setItem.definition + "</div>" + "<br>";
    boxContainer.appendChild(newBox);
    console.log();
}

function run() {
    let termJson, answerJson;
    console.log("pee");

    fetch('http://localhost:8080/terms')
        .then(response => response.json())
        .then(json => {
            termJson = json;
            console.log(termJson);
    })
    fetch('http://localhost:8080/answers')
        .then(response => response.json())
        .then(json => {
            answerJson = json;
            for(i = 0; i < termJson.length; i++) {
                console.log(termJson.length);
                count = termJson.length;
                var setItem = {
                    term: termJson[i].text,
                    definition: answerJson[i].text
                }
                console.log("pooopie");
                createBox(setItem);
            }
    console.log(count);
    })
}
