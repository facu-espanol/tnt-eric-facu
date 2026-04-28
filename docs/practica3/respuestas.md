# Ejercicio 4 – Ciclo de Vida Android
**Dispositivo utilizado:** Android 13 (API 36)

## Secuencia A  
**Acción:** Abrir app → Home → volver desde recientes  

onStart  
onResume  
onPause  
onStop  
onStart  
onResume  

---

## Secuencia B  
**Acción:** Presionar botón "Atrás" para salir  

onPause  
onStop  

---

## Secuencia C  
**Acción:** Ir a otra app (interrupción) y volver  

onPause  
onStop  
onStart  
onResume  

---

## Secuencia D  
**Acción:** Rotar la pantalla  

onPause  
onStop  
onDestroy  
onStart  
onResume  

---

# Respuestas

## 1. Diferencias entre "Atrás" y "Home"

En la **Secuencia A (Home)**:
onPause → onStop → onStart → onResume  

La app pasa a segundo plano y luego vuelve.

En la **Secuencia B (Atrás, tocando una sola vez)**:
onPause → onStop  

No aparece onDestroy, por lo que **onPause y onStop no implican que la app se destruya**.

**Conclusión:**
- Con Home: la app se pausa y luego continúa  
- Con Atrás: la app se detiene y no vuelve, aunque no se observa su destrucción en el log
---

## 2. Rotación de pantalla

Al rotar la pantalla, Android detecta un cambio de configuración.  
Para aplicar correctamente los recursos, destruye la actividad y la vuelve a crear.

Flujo:
- onPause  
- onStop  
- onDestroy  
- onStart  
- onResume  

Esto permite adaptar layouts, dimensiones y recursos a la nueva orientación.

---

# Observación sobre el contador

Cada vez que la app vuelve desde segundo plano, el contador aumenta porque se ejecuta onStart.

Pero al rotar:
- Se destruye la actividad  
- Se crea una nueva instancia  
- La variable se reinicia  

Por eso el contador vuelve a 0 y luego aumenta a 1 nuevamente.