import com.mrdoob.statsjs.Stats
import info.laht.threekt.cameras.PerspectiveCamera
import info.laht.threekt.core.Clock
import info.laht.threekt.external.controls.OrbitControls
import info.laht.threekt.external.loaders.OBJLoader
import info.laht.threekt.external.loaders.STLLoader
import info.laht.threekt.lights.DirectionalLight
import info.laht.threekt.materials.MeshPhongMaterial
import info.laht.threekt.math.ColorConstants
import info.laht.threekt.scenes.Scene
import info.laht.threekt.objects.Mesh
import info.laht.threekt.renderers.WebGLRenderer
import info.laht.threekt.renderers.WebGLRendererParams
import kotlinx.browser.document
import kotlinx.browser.window

class LoaderTest {

    val stats: Stats = Stats()
    val renderer: WebGLRenderer
    val scene: Scene = Scene()
    val camera: PerspectiveCamera
    val controls: OrbitControls
    val models: MutableList<Mesh> = ArrayList()
    var speed: Double = 1.0
    val clock: Clock = Clock(autoStart = true)

    init {

        val light = DirectionalLight(color = 0xffffff, intensity =  0.5)
        light.position.set(0, 0, -1)
        scene.add(light)

        camera = PerspectiveCamera(75, window.innerWidth.toDouble() / window.innerHeight, 0.1, 1000)
        camera.position.set(0, 5, -5)

        renderer = WebGLRenderer(WebGLRendererParams(
                antialias = true
        )).apply {
            setClearColor(ColorConstants.skyblue, alpha = 1)
            setSize(window.innerWidth, window.innerHeight)
        }

        document.getElementById("container")?.apply {
            appendChild(renderer.domElement)
            appendChild(stats.dom)
        }

        controls = OrbitControls(camera, renderer.domElement)

        STLLoader().apply {
            load("models/suzanne.stl", {
                Mesh(it, MeshPhongMaterial().apply {
                    color.set(0xff5533)
                    specular.set(0x111111)
                    shininess = 200.0
                }).also {
                    models.add(it)
                    scene.add(it)
                }
            })
        }

        OBJLoader().apply {
            load("models/suzanne.obj", {

                it.position.setX(-5)
                models.add(it)
                scene.add(it)

            })
        }

        window.addEventListener("resize", {
            camera.aspect = window.innerWidth.toDouble() / window.innerHeight
            camera.updateProjectionMatrix()
            renderer.setSize( window.innerWidth, window.innerHeight )
        }, false)

    }

    fun animate() {
        window.requestAnimationFrame {

            val dt = clock.getDelta()
            models.forEach {
                it.rotation.apply {
                    y += speed * dt
                }
            }
            animate()
        }
        renderer.render(scene, camera)
        stats.update()
    }

}
