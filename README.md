# SaborApp — Entrega 2, Semana 5

Aplicación Android académica del Equipo 5 — 5 BITS.

## Implementado
- MainActivity con dos zonas: menú y contenido.
- Fragments de Perfil, Recetas, Detalle, Video, Web y Botones.
- RecyclerView para recetas.
- Detalle con ingredientes, preparación, favorito y compartir.
- Favoritos persistentes en el detalle mediante SharedPreferences.
- WebView con validación de URL y estado de carga.
- VideoView + MediaController preparado para recurso MP4.
- Calculadora de porciones.
- Receta aleatoria, restablecer y compartir.
- Retroalimentación mediante Toast.
- Interfaz vino/crema inspirada en los mockups de la Entrega 1.

## Abrir en Android Studio
1. Descomprimir el ZIP.
2. Android Studio > File > Open.
3. Seleccionar la carpeta `SaborApp`.
4. Esperar Gradle Sync.
5. Ejecutar con un emulador o dispositivo Android API 24+.

## Video
El módulo está implementado. Para reproducir un video real:
1. Copiar un archivo `preparacion.mp4` a `app/src/main/res/raw/`.
2. En `VideoFragment.java`, asignar:
   `video.setVideoURI(Uri.parse("android.resource://" + requireContext().getPackageName() + "/" + R.raw.preparacion));`
3. Ejecutar `video.start()`.

## GitHub
Repositorio indicado en la Entrega 1: `frcardenas9/sabor-app`.

Antes de publicar, revisar el contenido remoto para no sobrescribir trabajo previo.
