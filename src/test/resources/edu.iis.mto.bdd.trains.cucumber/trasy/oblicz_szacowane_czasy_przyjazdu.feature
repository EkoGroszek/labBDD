# language: pl
Funkcja: Informacja dla podróżnych o czasie przybycia do stacji docelowej
	W celu bardziej efektywnego planowania podróży
	Jako podróżny
	Chcę wiedzieć, o której godzinie dotrę do stacji docelowej

Scenariusz : Szacowanie czasu przyjazdu
    Zakładając chcę się dostać z "Parramatta" do "TownHall"
  I następny pociąg na linii "Western" odjeżdża
    | 8:02 |
    | 8:03 |
    | 8:07 |
    | 8:13 |

  Gdy zapytam o godzinę przyjazdu
  Wtedy powinienem uzyskać następujący szacowany czas przyjazdu:
    | 8:29 |
    | 8:48 |
    | 8:37 |
    | 8:51 |


