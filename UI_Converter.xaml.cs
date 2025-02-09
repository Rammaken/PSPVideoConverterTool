using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Security.Policy;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using System.Xml.Linq;
using static System.Net.WebRequestMethods;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace PSPVideoConverterTool
{
    /// <summary>
    /// Lógica de interacción para UI_Converter.xaml
    /// </summary>


    public partial class UI_Converter : Window
    {
        public UI_Converter()
        {
            InitializeComponent();
        }

        private void set_input(object sender, RoutedEventArgs e)
        {
            var dialog = new System.Windows.Forms.FolderBrowserDialog();
            System.Windows.Forms.DialogResult result = dialog.ShowDialog();

            if (result == System.Windows.Forms.DialogResult.OK && !string.IsNullOrWhiteSpace(dialog.SelectedPath))
            {
                string path = dialog.SelectedPath;
                input_path.Text = path;
            }
        }

        private void set_output(object sender, RoutedEventArgs e)
        {
            var dialog = new System.Windows.Forms.FolderBrowserDialog();
            System.Windows.Forms.DialogResult result = dialog.ShowDialog();

            if (result == System.Windows.Forms.DialogResult.OK && !string.IsNullOrWhiteSpace(dialog.SelectedPath))
            {
                string path = dialog.SelectedPath;
                output_path.Text = path;
            }
        }

        private void convert_video(object sender, RoutedEventArgs e)
        {
            if (input_path.Text.Equals("") || output_path.Text.Equals(""))
            {
                System.Windows.MessageBox.Show("Set the paths first.", "Invalid action", MessageBoxButton.OK, MessageBoxImage.Warning);
            }
            else
            {
                // Declaring and getting paths
                string exePath = System.IO.Path.GetFullPath(@"bin\ffmpeg.exe");
                string inputPath = System.IO.Path.GetFullPath(input_path.Text);
                string outputPath = System.IO.Path.GetFullPath(output_path.Text);
                System.Boolean showConsole = true;
                System.Boolean generateThumbnail = false;

                // Actualizar la interfaz de usuario primero
                Dispatcher.Invoke(() =>
                {
                    status_progress.IsIndeterminate = true;
                });

                if (console_option.IsChecked == true)
                {
                    showConsole = false;
                }
                else
                {
                    showConsole = true;
                }

                if (thumbnail_option.IsChecked == true)
                {
                    generateThumbnail = true;
                }
                else
                {
                    generateThumbnail = false;
                }

                // Crear y ejecutar el hilo para el procesamiento
                Thread thread = new Thread(() =>
                {
                    // Stores all files in input path
                    string[] videoFiles = Directory.GetFiles(inputPath, "*.mp4").Select(System.IO.Path.GetFileNameWithoutExtension).ToArray();
                    // Loop for converting all files found
                    foreach (string file in videoFiles)
                    {
                        // Status output
                        Dispatcher.Invoke(() =>
                        {
                            log.Text += "Converting " + file + "...\n";
                        });

                        // Arguments declaration
                        string[] arguments = new string[]{
            "-i", "\"" + inputPath + "\\" + file + ".mp4\"",
            "-c:a", "aac",
            "-c:v", "libx264",
            "-profile:v", "main",
            "-level:v", "3.0",
            "-x264opts", "ref=3:b-pyramid=none:weightp=1",
            "-r", "29.97",
            "-s", "480x272",
            "-pix_fmt", "yuv420p",
            "-b:v", "768k",
            "-ar", "48000",
            "-ab", "192k",
            "\"" + outputPath + "\\" + file + ".mp4\""
        };

                        string ffmpegCommand = string.Join(" ", arguments);

                        // Declaring process with collected data
                        ProcessStartInfo startInfo = new ProcessStartInfo
                        {
                            FileName = exePath,
                            Arguments = ffmpegCommand,
                            RedirectStandardOutput = true,
                            UseShellExecute = false,
                            CreateNoWindow = showConsole
                        };

                        try
                        {
                            // Starts process
                            using (Process process = Process.Start(startInfo))
                            {
                                // Status output
                                using (StreamReader reader = process.StandardOutput)
                                {
                                    string output = process.StandardOutput.ReadToEnd();
                                    Dispatcher.Invoke(() =>
                                    {
                                        log.Text += output;
                                    });
                                }
                            }
                        }
                        catch (Exception ex)
                        {
                            Dispatcher.Invoke(() =>
                            {
                                System.Windows.MessageBox.Show(ex.Message, "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                            });
                        }

                        if (generateThumbnail == true)
                        {
                            string arguments_thumbnail = $"-i \"" + inputPath + "\\" + file + ".mp4\" -vf \"thumbnail,scale=160:120\" -frames:v 1 \"" + outputPath + "\\" + file + ".jpg\"";

                            // Declaring process with collected data
                            ProcessStartInfo startInfo_thumbnail = new ProcessStartInfo
                            {
                                FileName = exePath,
                                Arguments = arguments_thumbnail,
                                RedirectStandardOutput = true,
                                UseShellExecute = false,
                                CreateNoWindow = showConsole
                            };

                            try
                            {
                                // Starts process
                                using (Process process = Process.Start(startInfo_thumbnail))
                                {
                                    // Status output
                                    using (StreamReader reader = process.StandardOutput)
                                    {
                                        string output = process.StandardOutput.ReadToEnd();
                                    }
                                }
                            }
                            catch (Exception ex)
                            {
                                Dispatcher.Invoke(() =>
                                {
                                    System.Windows.MessageBox.Show(ex.Message, "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                                });
                            }
                            Dispatcher.Invoke(() =>
                            {
                                log.Text += "Thumbnail generated!\n";
                            });
                        }
                    }

                    // FINISH
                    Dispatcher.Invoke(() =>
                    {
                        NotifyIcon notifyIcon = new NotifyIcon();
                        notifyIcon.Icon = SystemIcons.Information;
                        notifyIcon.Text = "Process finished";

                        notifyIcon.BalloonTipTitle = "Conversion completed";
                        notifyIcon.BalloonTipText = "All videos were converted successfully.";
                        notifyIcon.BalloonTipIcon = ToolTipIcon.Info;
                        notifyIcon.Visible = true;
                        notifyIcon.ShowBalloonTip(3000);

                        status_progress.IsIndeterminate = false;

                        if (output_open_option.IsChecked == true)
                        {
                            Process.Start(new ProcessStartInfo
                            {
                                FileName = outputPath,
                                UseShellExecute = true,
                                Verb = "open"
                            });
                        }
                    });
                });

                thread.Start();


            }
        }

        private void show_info(object sender, RoutedEventArgs e)
        {
            System.Windows.MessageBox.Show("PSP Video Converter Tool\n\nVersion: 3.0\nCompilation date: 9/2/2025\nAuthor: Rammaken", "About");
        }


    }
}
