// DELETE BUTTON DATA COPY START
$('#modal-delete-config').on('show.bs.modal', function(e) {
	$(this).find('.btn-ok').attr('id', $(e.relatedTarget).data('href'));
});
// DELETE BUTTON DATA COPY END

// DELETE START
function onDelete(x) {
	var $elemId = x.id
	$.ajax({
		url : $elemId + '/delete',
		type : 'post',
		success : function(response) {
			$('#modal-delete-config').modal('hide');
			location.reload();
		}
	})
}
// DELETE END

function typeChanged(selectElement, className) {
	if (selectElement.value == "Integer") {
		$(className)[0].setAttribute('type', 'number');
		$(className)[0].setAttribute('step', '0');
	} else if (selectElement.value == "Double") {
		$(className)[0].setAttribute('type', 'number');
		$(className)[0].setAttribute('step', 'any');
	} else if (selectElement.value == "String") {
		$(className)[0].setAttribute('type', 'text');
		$(className)[0].setAttribute('step', '0');
	} else if (selectElement.value == "Boolean") {
		$(className)[0].setAttribute('type', 'text');
		$(className)[0].setAttribute('step', '0');
	}
}

// ADD Form Validation START
$(document).ready(function() {
	$("#addconfig").validate({
		ignore : ".ignore",
		rules : {
			name : {
				required : true,
				lettersonly : true
			},
			value : {
				required : true,
			},
			applicationName : {
				required : true,
				lettersonly : true
			}
		}
	})
})
// ADD Form Validation END

// EDIT Form Validation Start
$(document).ready(function() {
	$("#editconfig").validate({
		ignore : ".ignore",
		rules : {
			name : {
				required : true,
				lettersonly : true
			},
			value : {
				required : true,
			},
			applicationName : {
				required : true,
				lettersonly : true
			}
		}
	})
})
// EDIT Form Validation END

// Remove ID from modal if empty START
$('button.add').on('click', function() {
	var configModal = $('#modal-add-config');
	if ($('.id', configModal).value == null) {
		$('.id', configModal).remove();
	}
})
// Remove ID from modal if empty END

// EDIT BUTTON & FORM START
$('button.edit').on(
		'click',
		function() {
			var configModal = $('#modal-edit-config');
			// get values
			var name = $(this).closest('tr').find('td.name').html();
			var type = $(this).closest('tr').find('td.type').html();
			var value = $(this).closest('tr').find('td.value').html();
			var applicationName = $(this).closest('tr').find(
					'td.applicationname').html();
			var id = $(this).closest('tr').find('td.id').html();
			var isactive = $(this).closest('tr').find('td.isactive').html();

			// set values
			$('#name', configModal).val(name)
			$('#type', configModal).val(type)
			$('#value', configModal).val(value)
			$('#applicationName', configModal).val(applicationName)
			$('#id', configModal).val(id)

			configModal.modal({
				show : true
			});
		});
// EDIT BUTTON & FORM END

// RESET MODAL ON CLOSE START
$('#modal-add-config').on('hidden.bs.modal', function() {
	$(this).find('form')[0].reset();
});
$('#modal-edit-config').on('hidden.bs.modal', function() {
	$(this).find('form')[0].reset();
});
// RESET MODAL ON CLOSE END

