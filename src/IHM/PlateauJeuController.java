package IHM;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import modelisation.pieces.Piece;

public class PlateauJeuController {
	
/////////////////////////////////////////Attributs////////////////////////////////////////////
/////////////////////////////////////////Emplacement Images Cases////////////////////////////////////////////
	@FXML private ImageView a1; @FXML private ImageView a2; @FXML private ImageView a3; @FXML private ImageView a4;
	@FXML private ImageView a5; @FXML private ImageView a6; @FXML private ImageView a7; @FXML private ImageView a8;
	@FXML private ImageView b1; @FXML private ImageView b2; @FXML private ImageView b3; @FXML private ImageView b4;
	@FXML private ImageView b5; @FXML private ImageView b6; @FXML private ImageView b7; @FXML private ImageView b8;
	@FXML private ImageView c1; @FXML private ImageView c2; @FXML private ImageView c3; @FXML private ImageView c4;
	@FXML private ImageView c5; @FXML private ImageView c6; @FXML private ImageView c7; @FXML private ImageView c8;
	@FXML private ImageView d1; @FXML private ImageView d2; @FXML private ImageView d3; @FXML private ImageView d4;
	@FXML private ImageView d5; @FXML private ImageView d6; @FXML private ImageView d7; @FXML private ImageView d8;
	@FXML private ImageView e1; @FXML private ImageView e2; @FXML private ImageView e3; @FXML private ImageView e4;
	@FXML private ImageView e5; @FXML private ImageView e6; @FXML private ImageView e7; @FXML private ImageView e8; 
	@FXML private ImageView f1; @FXML private ImageView f2; @FXML private ImageView f3; @FXML private ImageView f4;
	@FXML private ImageView f5; @FXML private ImageView f6; @FXML private ImageView f7; @FXML private ImageView f8;
	@FXML private ImageView g1; @FXML private ImageView g2; @FXML private ImageView g3; @FXML private ImageView g4;
	@FXML private ImageView g5; @FXML private ImageView g6; @FXML private ImageView g7; @FXML private ImageView g8;
	@FXML private ImageView h1; @FXML private ImageView h2; @FXML private ImageView h3; @FXML private ImageView h4;
	@FXML private ImageView h5; @FXML private ImageView h6; @FXML private ImageView h7; @FXML private ImageView h8;

/////////////////////////////////////////Emplacement Images Cases Pièces////////////////////////////////////////////
	@FXML private ImageView Pa1; @FXML private ImageView Pa2; @FXML private ImageView Pa3; @FXML private ImageView Pa4;
	@FXML private ImageView Pa5; @FXML private ImageView Pa6; @FXML private ImageView Pa7; @FXML private ImageView Pa8;
	@FXML private ImageView Pb1; @FXML private ImageView Pb2; @FXML private ImageView Pb3; @FXML private ImageView Pb4;
	@FXML private ImageView Pb5; @FXML private ImageView Pb6; @FXML private ImageView Pb7; @FXML private ImageView Pb8;
	@FXML private ImageView Pc1; @FXML private ImageView Pc2; @FXML private ImageView Pc3; @FXML private ImageView Pc4;
	@FXML private ImageView Pc5; @FXML private ImageView Pc6; @FXML private ImageView Pc7; @FXML private ImageView Pc8;
	@FXML private ImageView Pd1; @FXML private ImageView Pd2; @FXML private ImageView Pd3; @FXML private ImageView Pd4;
	@FXML private ImageView Pd5; @FXML private ImageView Pd6; @FXML private ImageView Pd7; @FXML private ImageView Pd8;
	@FXML private ImageView Pe1; @FXML private ImageView Pe2; @FXML private ImageView Pe3; @FXML private ImageView Pe4;
	@FXML private ImageView Pe5; @FXML private ImageView Pe6; @FXML private ImageView Pe7; @FXML private ImageView Pe8; 
	@FXML private ImageView Pf1; @FXML private ImageView Pf2; @FXML private ImageView Pf3; @FXML private ImageView Pf4;
	@FXML private ImageView Pf5; @FXML private ImageView Pf6; @FXML private ImageView Pf7; @FXML private ImageView Pf8;
	@FXML private ImageView Pg1; @FXML private ImageView Pg2; @FXML private ImageView Pg3; @FXML private ImageView Pg4;
	@FXML private ImageView Pg5; @FXML private ImageView Pg6; @FXML private ImageView Pg7; @FXML private ImageView Pg8;
	@FXML private ImageView Ph1; @FXML private ImageView Ph2; @FXML private ImageView Ph3; @FXML private ImageView Ph4;
	@FXML private ImageView Ph5; @FXML private ImageView Ph6; @FXML private ImageView Ph7; @FXML private ImageView Ph8;
	
	@FXML private void RayonAction(MouseEvent me) {
		System.out.println(me.getSource());
		}
	}
