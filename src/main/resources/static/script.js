function submitNumbers() {
    const input = document.getElementById("numberInput").value;
    const numberArray = input.split(',').map(num => parseInt(num.trim())).filter(n => !isNaN(n));

    fetch('/process-numbers', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(numberArray)
    })
    .then(res => res.json())
    .then(data => {
        document.getElementById("treeOutput").textContent = JSON.stringify(data, null, 2);
        fetchPreviousTrees();
    })
    .catch(err => {
        document.getElementById("treeOutput").textContent = "Error building tree: " + err;
    });
}

function fetchPreviousTrees() {
    fetch('/previous-trees')
        .then(res => res.json())
        .then(data => {
            const list = document.getElementById("previousTreesList");
            list.innerHTML = "";
            data.forEach(record => {
                const li = document.createElement("li");
                li.textContent = `Input: [${record.inputNumbers}]`;
                list.appendChild(li);
            });
        });
}

window.onload = fetchPreviousTrees;
