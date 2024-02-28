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