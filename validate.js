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
      haus: true,
      normalizer: function(value) {
        return $.trim(value);
      }
    }
  },
  messages: {
    password: {
      required: "Bitte ein Passwort eingeben",
      minlength: "PW zu kurz"
    }
  }
});
