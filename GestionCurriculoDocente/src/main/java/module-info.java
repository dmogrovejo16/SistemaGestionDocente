module TareaFinCurso.GestionCurriculoDocente {
    requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
    exports TareaFinCurso.GestionCurriculoDocente;
    
    opens TareaFinCurso.GestionCurriculoDocente.Model to javafx.base;
}
