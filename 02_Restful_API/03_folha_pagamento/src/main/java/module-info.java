module App {
    requires javafx.controls;
    requires javafx.fxml;
    requires atlantafx.base;
    // requires com.fasterxml.jackson.databind;
    opens edu.ifsc.folha_pagamento to javafx.fxml;
    opens edu.ifsc.folha_pagamento.controller to javafx.fxml;
    exports edu.ifsc.folha_pagamento;
}