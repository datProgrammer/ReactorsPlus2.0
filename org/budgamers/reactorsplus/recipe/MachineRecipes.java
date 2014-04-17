package org.budgamers.reactorsplus.recipe;


public class MachineRecipes {

	public static final EnrichmentRecipes enrichment = new EnrichmentRecipes();
	public static final StabilizerRecipes stabilization = new StabilizerRecipes();
	public static final CompressorRecipes compressor = new CompressorRecipes();
	public static final IsotopeReactorRecipes isotopeReactor = new IsotopeReactorRecipes();
	public static final PlatingRecipes plating = new PlatingRecipes();
	
	public static EnrichmentRecipes enrichment() {
		return enrichment;
	}
	
	public static StabilizerRecipes stabilize() {
		return stabilization;
	}
	
	public static CompressorRecipes compressor() {
		return compressor;
	}
	
	public static IsotopeReactorRecipes isotopeReactor() {
		return isotopeReactor;
	}
	
	public static PlatingRecipes plating() {
		return plating;
	}
}
