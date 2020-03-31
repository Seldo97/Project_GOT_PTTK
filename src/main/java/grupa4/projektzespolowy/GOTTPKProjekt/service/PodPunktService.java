package grupa4.projektzespolowy.GOTTPKProjekt.service;

import java.util.List;


import grupa4.projektzespolowy.GOTTPKProjekt.model.PodPunkt;

public interface PodPunktService 
{
	 PodPunkt createPodPunkt(PodPunkt podpunkt);

	    List<PodPunkt> getAllPodPunkt();

	    PodPunkt getOneById(Integer id);

	    void removePodPunkt(Integer id);
}
