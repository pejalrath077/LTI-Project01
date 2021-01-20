
window.onload = function() {
    
}

let realData = [];
$.getJSON('https://cors-anywhere.herokuapp.com/https://lti-project-01.herokuapp.com/getRequestForm').then(data => {
    realData = data;
    console.log(`Real Data is: ${realData}`);
    buildTable(realData);
});

function buildTable(arr) {

    for(let i = 0; i < arr.length; i++) {

        // create a row of data
        let row = `
            <th scope="row">${arr[i].id}</th>
            <td>${arr[i].system}</td>
            <td>${arr[i].issues}</td>
            <td>${arr[i].reportedDate}</td>
            <td>${arr[i].criticality}</td>
            <td>${arr[i].pendingWith}</td>
            <td>${arr[i].status}</td>
            <td>${arr[i].verifiedBy}</td>
            <td>${arr[i].targetDate}</td>
            <td>${arr[i].closureDate}</td>
            <td>${arr[i].remark}</td>
            <td>${arr[i].reportedBy}</td>
        `

        // add the row to the table
        let tr = document.createElement('tr');
        tr.setAttribute('id', i);
        tr.innerHTML = row;
        document.getElementById('table-body').appendChild(tr);
    }
    console.log("Hello Anthony");

    // show the table
    // document.getElementById('own-reimbursements').classList.remove('d-none');
}
