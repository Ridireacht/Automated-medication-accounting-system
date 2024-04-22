function deleteRecord(button, url) {
  if (confirm('Вы уверены, что хотите удалить эту запись?')) {
    var row = button.closest('tr');
    var recordId = row.querySelector('td:first-child').textContent;

    fetch(url + recordId, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json'
      }
    })
    .then(response => {
      if (!response.ok) {
        return response.json().then(errorData => {
          var errorMessage = errorData.message;
          throw new Error(errorMessage);
        });
      }
      row.remove();
    })
    .catch(error => {
      alert('Ошибка удаления записи ' + error.message);
    });
  }
}


function compareValues1(x, y) {
    var numX = parseFloat(x.innerHTML.trim());
    var numY = parseFloat(y.innerHTML.trim());

    if (!isNaN(numX) && !isNaN(numY)) {
        return numX > numY;
    }

    return x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase();
}


function compareValues2(x, y) {
    var numX = parseFloat(x.innerHTML.trim());
    var numY = parseFloat(y.innerHTML.trim());

    if (!isNaN(numX) && !isNaN(numY)) {
        return numX < numY;
    }

    return x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase();
}


function sortTable(n) {
  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;

  table = document.getElementById("records-table");
  switching = true;
  dir = "asc";

  while (switching) {
    switching = false;
    rows = table.rows;

    for (i = 1; i < (rows.length - 1); i++) {
      shouldSwitch = false;
      x = rows[i].getElementsByTagName("TD")[n];
      y = rows[i + 1].getElementsByTagName("TD")[n];

      if (dir == "asc") {
        if (compareValues1(x, y)) {
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (compareValues2(x, y)) {
          shouldSwitch = true;
          break;
        }
      }
    }

    if (shouldSwitch) {
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
      switchcount ++;
    } else {
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}


function searchTable() {
  var input, filter, table, tr, td, i, txtValue;

  input = document.getElementById("searchInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("records-table");
  tr = table.getElementsByTagName("tr");

  for (i = 0; i < tr.length; i++) {
    const tableData = tr[i].getElementsByTagName("td");
    let allTextContent = '';

    for (let ind = 0; ind < tableData.length; ind++) {
        allTextContent += tableData[ind].innerText;
    }

    if (allTextContent) {
      if (allTextContent.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}


function sendPostRequest(requestBody, url) {
    fetch(url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(requestBody)
    })
    .then(response => {
      if (!response.ok) {
        return response.json().then(errorData => {
          var errorMessage = errorData.message;
          throw new Error(errorMessage);
        });
      }
      window.location.reload();
    })
    .catch(error => {
      alert('Ошибка при добавлении: ' + error.message);
    });
}


function enableEdit(element, url, fieldName) {
  if (!element.hasAttribute('contenteditable')) {
    element.setAttribute('contenteditable', true);
    element.focus();

    var oldValue = element.textContent;

    function onBlurHandler() {
      var recordId = element.parentElement.querySelector('td:first-child').textContent;
      var newValue = element.textContent.trim();

      var requestBody = {
        type: fieldName,
        value: newValue
      };

      fetch(url + recordId, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestBody)
      })
      .then(response => {
        if (!response.ok) {
          return response.json().then(errorData => {
            var errorMessage = errorData.message;
            throw new Error(errorMessage);
          });
        }
        return response.json();
      })
      .then(data => {
        element.removeAttribute('contenteditable');
        element.removeEventListener('blur', onBlurHandler);
      })
      .catch(error => {
        alert('Ошибка обновления поля: ' + error.message);
        element.textContent = oldValue;
      });
    }

    element.addEventListener('blur', onBlurHandler);
  }
}


function updateSelected(element, url, fieldName) {
      var recordId = element.parentElement.parentElement.querySelector('td:first-child').textContent;
      var newValue = element.value.toString();

      var requestBody = {
        type: fieldName,
        value: newValue
      };

      fetch(url + recordId, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestBody)
      })
      .then(response => {
        if (!response.ok) {
          return response.json().then(errorData => {
            var errorMessage = errorData.message;
            throw new Error(errorMessage);
          });
        }
      })
      .catch(error => {
        alert('Ошибка обновления поля: ' + error.message);
        element.textContent = oldValue;
      });
}