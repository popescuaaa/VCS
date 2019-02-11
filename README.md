# VCS

			------------------------------------------------------------------------------
			 VCS -> Popescu Andrei Gabriel
			------------------------------------------------------------------------------


			.
			??? Branch.java
			??? BranchOperation.java
			??? CheckOutOperation.java
			??? Commit.java
			??? CommitOperation.java
			??? LogOperation.java
			??? RollBackOperation.java
			??? StatusOperation.java
			??? VcsInvalidOp.java
			??? Vcs.java   // deja existenet 
			??? VcsOperation.java // deja existent



			------------------------------------------------------------------------------
			Descriere
			------------------------------------------------------------------------------
			Proiectul se bazeaza pe implementarea unor comenzi specifice unui version control system.
			Am folosit scheletul propus si am ales sa fac toate implementarile initializarile in 
			Context in caz ca voi avea nevoie de anumiti parametri din clasa respecitiva pe parcurs.
			Am implementat fiecare comanda precizata si totodata am adaugat doua alte clase, Branch si 
			Commit care contin parametrii specifici unei astfel de entitati.

			Parcursul se bazeaza pe schimbari de astfel de entitati de tip branch sau commit si pe 
			actualizari ale sistemului de fisiere, mai bine zis a variantei de sistem de fisiere din 
			etapa respectiva.