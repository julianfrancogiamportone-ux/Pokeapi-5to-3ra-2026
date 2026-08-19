const POKE_API = 'http://localhost:8080/api/characters';
const starapi = 'http://localhost:8081/api/characters';

fetch('http://localhost:8081/api/character')
  .then(res => res.json())
  .then(data => {
    console.log("Datos API 2:", data);
  });
const Peleador1Select = document.getElementById('Peleador1');
const Peleador2Select = document.getElementById('Peleador2');
const Peleador1Image = document.getElementById('Peleador1Image');
const Peleador2Image = document.getElementById('Peleador2Image');
const fightButton = document.getElementById('fightButton');
const resultDiv = document.getElementById('result');
//guardamos los datos obtenidos
let characters = [];
let characters2 = [];

async function fetchData() {
    try {
        const responsePK = await fetch(POKE_API);
        characters = await responsePK.json();}   
    catch (error) {
        console.error('Error al cargar los personajes:', error);
    }
    
    try {
        const responseBS = await fetch(starapi);
        characters2 = await responseBS.json();} 
    catch (error) {
        console.error('Error al cargar los personajes:', error);
    }

    loadPeleadores();
    loadPeleadores2();
}

function loadPeleadores() {[...characters].forEach(Peleador => {
    const option1 = document.createElement('option');
    option1.value = JSON.stringify(Peleador);
    option1.text = `${Peleador.nombre} (${Peleador.armas[(Math.floor(Math.random() * 2) + 0)].nombre})`;
    Peleador1Select.appendChild(option1);
});

const selected = JSON.parse(Peleador1Select.value);
Peleador1Image.src = selected.imgurl;}

function loadPeleadores2() {
    Peleador2Select.innerHTML = ''; // Limpiar opciones previas

    [...characters2].forEach(Peleador => {
        const option2 = document.createElement('option');
        option2.value = JSON.stringify(Peleador);
        
        // Manejo seguro por si viene 'arma', 'armas' o sin armas
        const nombreArma = Peleador.arma?.[0]?.nombre 
                        || Peleador.armas?.[0]?.nombre 
                        || 'Sin arma';

        option2.text = `${Peleador.nombre} (${nombreArma})`;
        Peleador2Select.appendChild(option2);
    });

    if (Peleador2Select.value) {
        const selected2 = JSON.parse(Peleador2Select.value);
        // Busca cualquier variante con la que el backend haya nombrado la propiedad
        Peleador2Image.src = selected2.URLimagen 
                          || selected2.urlImagen 
                          || selected2.uRLImagen 
                          || selected2.urlimagen 
                          || selected2.imgurl 
                          || '';
    }
}

Peleador2Select.addEventListener('change', () => {
    const selected = JSON.parse(Peleador2Select.value);
    Peleador2Image.src = selected.URLimagen 
                      || selected.urlImagen 
                      || selected.uRLImagen 
                      || selected.urlimagen 
                      || selected.imgurl 
                      || '';
});

Peleador1Select.addEventListener('change', () => {
    const selected = JSON.parse(Peleador1Select.value);
    Peleador1Image.src = selected.imgurl || selected.urlImagen || selected.uRLImagen || selected.urlimagen || selected.imgurl || '';
});

Peleador2Select.addEventListener('change', () => {
    const selected = JSON.parse(Peleador2Select.value);
    Peleador2Image.src = selected.URLimagen|| selected.urlImagen || selected.uRLImagen || selected.urlimagen || selected.imgurl || '';
});

fightButton.addEventListener('click', () => {
    const fighter1 = JSON.parse(Peleador1Select.value);
    const fighter2 = JSON.parse(Peleador2Select.value);
    let winner;
    if (!fighter1 || !fighter2) {
        alert('Seleccioná ambos luchadores.');
        return;
    }
    if (fighter1.puntosVida > fighter2.puntosVida) {
		winner = fighter1.nombre;} 
    else if (fighter1.puntosVida === fighter2.puntosVida){
        winner = "¡Empate!";} 
    else{
		winner = fighter2.nombre;}
      
    resultDiv.textContent = `🏆 El ganador es: ${winner}! 🥊`;
    resultDiv.classList.remove('hidden');
})
fetchData();
