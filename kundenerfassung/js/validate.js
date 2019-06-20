jQuery.validator.addMethod("passwords", function(value, element)
{
  return this.optional(element) ||
  /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{6,}$/.test(value);
},	"Zu schwaches Passwort!");
jQuery.validator.classRuleSettings.passwords = {passwords: true};


jQuery("#myform").validate({
  rules: {
    password: {
      required: true,
      passwords: true,
      normalizer: function(value) {
        return $.trim(value);
      }
    },
    email: {
      required: true
    }

  },
  messages: {
    password: {
      required: "Bitte ein Passwort eingeben",
      minlength: "PW zu kurz"
    },
    email: {
      required: "Benutzername muss eingegeben werden",
      email: "Gültige E-Mail-Adresse eingeben"
    }
  }
});
